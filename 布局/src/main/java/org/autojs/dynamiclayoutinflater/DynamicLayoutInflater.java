package org.autojs.dynamiclayoutinflater;

import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.autojs.dynamiclayoutinflater.attrsetter.*;
import org.autojs.dynamiclayoutinflater.util.*;
import org.w3c.dom.*;

/**
 * Copyright Nicholas White 2015.
 * Source: https://github.com/nickwah/DynamicLayoutInflator
 * <p>
 * Licensed under the MIT License:
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
public class DynamicLayoutInflater {
    private static final String LOG_TAG = "DynamicLayoutInflater";

    private Map<String, ViewAttrSetter<?>> mViewAttrSetters = new HashMap<>();
    private Map<String, ViewCreator<?>> mViewCreators = new HashMap<>();
    private Context mContext;

    public DynamicLayoutInflater(Context context) {
        mContext = context;
        registerViewAttrSetter(TextView.class.getName(), new TextViewAttrSetter<>());
        registerViewAttrSetter(EditText.class.getName(), new TextViewAttrSetter<>());
        registerViewAttrSetter(ImageView.class.getName(), new ImageViewAttrSetter<>());
        registerViewAttrSetter(LinearLayout.class.getName(), new LinearLayoutAttrSetter<>());
        registerViewAttrSetter(FrameLayout.class.getName(), new FrameLayoutAttrSetter<>());
        registerViewAttrSetter(View.class.getName(), new BaseViewAttrSetter<>());
        registerViewAttrSetter(DatePicker.class.getName(), new DatePickerAttrSetter());
        registerViewAttrSetter(RadioGroup.class.getName(), new RadioGroupAttrSetter<>());
        registerViewAttrSetter(ProgressBar.class.getName(), new ProgressBarAttrSetter<>());
        registerViewAttrSetter(Spinner.class.getName(), new SpinnerAttrSetter());
        registerViewAttrSetter(TimePicker.class.getName(), new TimePickerAttrSetter());

    }

    public void registerViewAttrSetter(String fullName, ViewAttrSetter<?> setter) {
        mViewAttrSetters.put(fullName, setter);
        ViewCreator<?> creator = setter.getCreator();
        if (creator != null) {
            mViewCreators.put(fullName, creator);
        }
    }

    public View inflate(String xml) {
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        return inflate(inputStream);
    }

    public View inflate(String xml, ViewGroup parent) {
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
        return inflate(inputStream, parent);
    }

    public View inflate(InputStream inputStream) {
        return inflate(inputStream, null);
    }

    public View inflate(InputStream inputStream, ViewGroup parent) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setNamespaceAware(true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(inputStream);
            return inflate(document.getDocumentElement(), parent);
        } catch (Exception e) {
            throw new InflateException(e);
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private View inflate(Node node, ViewGroup parent) {
        HashMap<String, String> attrs = getAttributesMap(node);
        View view = createViewForName(node.getNodeName(), attrs);
        if (parent != null) {
            parent.addView(view); // have to add to parent to enable certain layout attrs
        }
        ViewAttrSetter<View> setter = (ViewAttrSetter<View>) getViewAttrSetter(view);
        applyAttributes(view, setter, attrs, parent);
        if (view instanceof ViewGroup && node.hasChildNodes()) {
            inflateChildren(node, (ViewGroup) view);
            if (setter instanceof ViewGroupAttrSetter) {
                ((ViewGroupAttrSetter) setter).applyPendingAttributesAboutChildren((ViewGroup) view);
            }
        }
        return view;
    }

    private ViewAttrSetter<?> getViewAttrSetter(View view) {
        ViewAttrSetter<?> setter = mViewAttrSetters.get(view.getClass().getName());
        Class c = view.getClass();
        while (setter == null && c != View.class) {
            c = c.getSuperclass();
            setter = mViewAttrSetters.get(c.getName());
        }
        return setter;
    }

    private void inflateChildren(Node node, ViewGroup parent) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() != Node.ELEMENT_NODE) continue;
            inflate(currentNode, parent); // this recursively can call inflateChildren
        }
    }

    private View createViewForName(String name, HashMap<String, String> attrs) {
        try {
            if (name.equals("View")) {
                return new View(mContext);
            }
            if (!name.contains(".")) {
                name = "android.widget." + name;
            }
            ViewCreator<?> creator = mViewCreators.get(name);
            if (creator != null) {
                return creator.create(mContext, attrs);
            }
            Class<?> clazz = Class.forName(name);
            String style = attrs.get("style");
            if (style == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                return (View) clazz.getConstructor(Context.class).newInstance(mContext);
            } else {
                int styleRes = Res.parseStyle(mContext, style);
                return (View) clazz.getConstructor(Context.class, AttributeSet.class, int.class, int.class)
                        .newInstance(mContext, null, 0, styleRes);
            }
        } catch (Exception e) {
            throw new InflateException(e);
        }
    }


    private HashMap<String, String> getAttributesMap(Node currentNode) {
        NamedNodeMap attributeMap = currentNode.getAttributes();
        int attributeCount = attributeMap.getLength();
        HashMap<String, String> attributes = new HashMap<>(attributeCount);
        for (int j = 0; j < attributeCount; j++) {
            Node attr = attributeMap.item(j);
            String nodeName = attr.getNodeName();
            attributes.put(nodeName, attr.getNodeValue());
        }
        return attributes;
    }

    @SuppressWarnings("unchecked")
    private void applyAttributes(View view, ViewAttrSetter<View> setter, Map<String, String> attrs, ViewGroup parent) {
        if (setter != null) {
            for (Map.Entry<String, String> entry : attrs.entrySet()) {
                String[] attr = entry.getKey().split(":");
                if (attr.length == 1) {
                    setter.setAttr(view, attr[0], entry.getValue(), parent, attrs);
                } else if (attr.length == 2) {
                    setter.setAttr(view, attr[0], attr[1], entry.getValue(), parent, attrs);
                } else {
                    throw new InflateException("illegal attr name: " + entry.getKey());
                }
            }
            setter.applyPendingAttributes(view, parent);
        } else {
            Log.e(LOG_TAG, "cannot set attributes for view: " + view.getClass());
        }

    }


}
