package org.autojs.dynamiclayoutinflater.attrsetter;

import android.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.text.*;
import java.util.*;
import org.autojs.dynamiclayoutinflater.*;

/**
 * Created by Stardust on 2017/11/29.
 */

public class DatePickerAttrSetter extends BaseViewAttrSetter<DatePicker> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("mm/dd/yyyy", Locale.getDefault());

    @Override
    public boolean setAttr(DatePicker view, String attr, String value, ViewGroup parent, Map<String, String> attrs) {
        switch (attr) {
            case "calendarTextColor":
                Exceptions.unsupports(view, attr, value);
                break;
            case "calendarViewShown":
                view.setCalendarViewShown(Boolean.parseBoolean(attr));
                break;
            case "dayOfWeekBackground":
            case "dayOfWeekTextAppearance":
            case "endYear":
                Exceptions.unsupports(view, attr, value);
                break;
            case "firstDayOfWeek":
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    view.setFirstDayOfWeek(Integer.parseInt(value));
                }
                break;
            case "headerBackground":
            case "headerDayOfMonthTextAppearance":
            case "headerMonthTextAppearance":
            case "headerYearTextAppearance":
                Exceptions.unsupports(view, attr, value);
                break;
            case "maxDate":
                try {
                    view.setMaxDate(DATE_FORMAT.parse(value).getTime());
                } catch (ParseException e) {
                    throw new InflateException(e);
                }
                break;
            case "minDate":
                try {
                    view.setMinDate(DATE_FORMAT.parse(value).getTime());
                } catch (ParseException e) {
                    throw new InflateException(e);
                }
                break;
            case "spinnersShown":
                view.setSpinnersShown(Boolean.parseBoolean(value));
                break;
            case "startYear":
            case "yearListItemTextAppearance":
            case "yearListSelectorColor":
                Exceptions.unsupports(view, attr, value);
                break;
            default:
                return super.setAttr(view, attr, value, parent, attrs);
        }
        return true;
    }

    @Override
    public ViewCreator<DatePicker> getCreator() {
        return new ViewCreator<DatePicker>() {
            @Override
            public DatePicker create(Context context, Map<String, String> attrs) {
                String datePickerMode = attrs.remove("android:datePickerMode");
                if (datePickerMode == null || !datePickerMode.equals("spinner")) {
                    return new DatePicker(context);
                }
                DatePicker datePicker = new DatePicker(context);
                datePicker.setCalendarViewShown(false);
                return datePicker;
            }
        };
    }
}
