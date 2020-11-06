package com.example.cs5610fall2020serverjavashenglan.services;

import com.example.cs5610fall2020serverjavashenglan.models.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
//    {
//        widgets.add(new Widget("123", "Widget A", "HEADING", "5fa2da680df073001729cde4"));
//        widgets.add(new Widget("234", "Widget B", "PARAGRAPH","5fa2da680df073001729cde4"));
//        widgets.add(new Widget("345", "Widget C", "HEADING","5fa2da680df073001729cde4"));
//    }

    public List<Widget> findWidgetsForTopic(String topicId){
        List<Widget> ws = new ArrayList<Widget>();
        for (Widget w: widgets) {
            if(w.getTopicId().equals(topicId)){
                ws.add(w);
            }
        }
        return ws;
    }

    public Widget createWidget(String topicId, Widget widget) {
        widget.setId((new Date()).toString());
        widget.setTopicId(topicId);
        if(widget.getWidgetOrder() == null){
            widget.setWidgetOrder((widgets.size()));
        }
        if(widget.getText() == null){
            widget.setText("");
        }
        widgets.add(widget);
        return widget;
    }


    public Integer updateWidget(String widgetId, Widget newWidget){
        for(Widget w:widgets){
            if (w.getId().equals(widgetId)){
                w.setText(newWidget.getText());
                w.setName(newWidget.getName());
                w.setType(newWidget.getType());
                w.setSize(newWidget.getSize());
                w.setEditing(newWidget.isEditing());
                w.setWidgetOrder(newWidget.getWidgetOrder());
                return 1;
            }
        }
        return 0;
    }

    public Integer deleteWidget(String wid){
        for(Widget w: widgets){
            if(w.getId().equals(wid)){
                widgets.remove(w);
                return 1;
            }
        }
        return 0;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public Widget findWidgetById(String widgetId) {
        for(Widget w: widgets){
            if (w.getId().equals(widgetId))
                return w;
        }
        return null;
    }
}
