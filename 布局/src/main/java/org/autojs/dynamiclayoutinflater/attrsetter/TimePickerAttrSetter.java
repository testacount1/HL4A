package org.autojs.dynamiclayoutinflater.attrsetter;

import android.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import org.autojs.dynamiclayoutinflater.*;

/**
 * Created by Stardust on 2017/11/29.
 */

public class TimePickerAttrSetter extends BaseViewAttrSetter<TimePicker> {

    @Override
    public ViewCreator<TimePicker> getCreator() {
        return new ViewCreator<TimePicker>() {
            @Override
            public TimePicker create(Context context, Map<String, String> attrs) {
                String datePickerMode = attrs.remove("android:timePickerMode");
                if (datePickerMode == null || !datePickerMode.equals("spinner")) {
                    return new TimePicker(context);
                }
                return new TimePicker(context);
            }
        };
    }
}
