package com.stardust.autojs.apkbuilder;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import pxb.android.StringItem;
import pxb.android.axml.AxmlReader;
import pxb.android.axml.AxmlWriter;
import pxb.android.axml.NodeVisitor;
import 放课后乐园部.工具.*;
import 放课后乐园部.安卓.工具.*;
import 放课后乐园部.收集.*;
import java.util.*;

/**
 * Created by Stardust on 2017/10/23.
 */

public class ManifestEditor {


    private static final String NS_ANDROID = "http://schemas.android.com/apk/res/android";
    private InputStream mManifestInputStream;
    private int mVersionCode = -1;
    private String mVersionName;
    private String mAppName;
    private String mPackageName;
    private byte[] mManifestData;
    private List<String> mPermissions;


    public ManifestEditor(String $地址) {
        mManifestInputStream = 流工具.输入.文件($地址);
    }

    public void setPermissions(List<String> mPermissions) {
        this.mPermissions = mPermissions;
    }

    public List<String> getPermissions() {
        return mPermissions;
    }

    public ManifestEditor setVersionCode(int versionCode) {
        mVersionCode = versionCode;
        return this;
    }

    public ManifestEditor setVersionName(String versionName) {
        mVersionName = versionName;
        return this;
    }

    public ManifestEditor setAppName(String appName) {
        mAppName = appName;
        return this;
    }

    public ManifestEditor setPackageName(String packageName) {
        mPackageName = packageName;
        return this;
    }


    public ManifestEditor commit() throws IOException {
        AxmlWriter writer = new MutableAxmlWriter();
        AxmlReader reader = new AxmlReader(IOUtils.readFully(mManifestInputStream, mManifestInputStream.available()));
        reader.accept(writer);
        mManifestData = writer.toByteArray();
        return this;
    }


    public void writeTo(OutputStream manifestOutputStream) throws IOException {
        manifestOutputStream.write(mManifestData);
        manifestOutputStream.close();
    }

    public void onAttr(AxmlWriter.Attr attr) {
        //提示工具.普通(attr.name.data);
        if ("package".equals(attr.name.data) && mPackageName != null && attr.value instanceof StringItem) {
            ((StringItem) attr.value).data = mPackageName;
            return;
        }
        if (attr.ns == null || !NS_ANDROID.equals(attr.ns.data)) {
            return;
        }
        if ("versionCode".equals(attr.name.data) && mVersionCode != -1) {
            attr.value = mVersionCode;
            return;
        }
        if ("versionName".equals(attr.name.data) && mVersionName != null && attr.value instanceof StringItem) {
            //attr.value = new StringItem(mVersionName);
            ((StringItem) attr.value).data = mVersionName;
            return;
        }
        if ("label".equals(attr.name.data) && mAppName != null && attr.value instanceof StringItem) {
            ((StringItem) attr.value).data = mAppName;
            return;
        }
        if ("name".equals(attr.name.data) && mAppName != null && attr.value instanceof StringItem) {
            switch (((StringItem) attr.value).data) {
                    case "实例应用类":((StringItem) attr.value).data = mPackageName + ".Application";return;
                    case "实例启动类":((StringItem) attr.value).data = mPackageName + ".LaunchPad";return;
            }
            return;
        }
    }


    private class MutableAxmlWriter extends AxmlWriter {
        private class MutableNodeImpl extends AxmlWriter.NodeImpl {

            MutableNodeImpl(String ns,String name) {
                super(ns, name);
            }

            @Override
            protected void onAttr(AxmlWriter.Attr a) {
                ManifestEditor.this.onAttr(a);
                super.onAttr(a);
            }


            @Override
            public NodeVisitor child(String ns,String name) {
                NodeImpl child = new MutableNodeImpl(ns, name);
                this.children.add(child);
                if (name.equals("uses-permission"))
                    addpermission_once();
                //提示工具.普通(ns);
                return child;
            }

            boolean needadd = true;

            private void addpermission_once() {
                if (needadd && mPermissions != null) {
                    for (String per : mPermissions) {
                        NodeImpl child = new MutableNodeImpl(null, "uses-permission");
                        this.children.add(child);
                        child.attr(NS_ANDROID, "name", 16842775, NodeVisitor.TYPE_STRING, per);
                        //return child;
                    }
                    needadd = false;
                }
            }

        }

        @Override
        public NodeVisitor child(String ns,String name) {
            NodeImpl first = new MutableNodeImpl(ns, name);
            this.firsts.add(first);
            return first;
        }
    }


}
