package org.autojs.dynamiclayoutinflater;

import android.view.View;
import android.view.ViewGroup;

import java.util.Map;

/**
 * Created by Stardust on 2017/11/3.
 */


public interface ViewAttrSetter<V extends View> {

    boolean setAttr(V view, String attrName, String value, ViewGroup parent, Map<String, String> attrs);

    boolean setAttr(V view, String ns, String attrName, String value, ViewGroup parent, Map<String, String> attrs);

    void applyPendingAttributes(V view, ViewGroup parent);

    ViewCreator<V> getCreator();
}
