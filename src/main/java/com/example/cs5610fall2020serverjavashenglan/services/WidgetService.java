package com.example.cs5610fall2020serverjavashenglan.services;

import com.example.cs5610fall2020serverjavashenglan.models.Widget;
import com.example.cs5610fall2020serverjavashenglan.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
    @Autowired
    WidgetRepository widgetRepository;

//    List<Widget> widgets = new ArrayList<Widget>();
//    {
//        widgets.add(new Widget("123", "Widget A", "HEADING", "5fa2da680df073001729cde4"));
//        widgets.add(new Widget("234", "Widget B", "PARAGRAPH","5fa2da680df073001729cde4"));
//        widgets.add(new Widget("345", "Widget C", "HEADING","5fa2da680df073001729cde4"));
//    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
//        for(Widget w: widgets){
//            if (w.getId().equals(widgetId))
//                return w;
//        }
//        return null;
    }

    public List<Widget> findWidgetsForTopic(String topicId){
        return widgetRepository.findWidgetsForTopic(topicId);
//        List<Widget> ws = new ArrayList<Widget>();
//        for (Widget w: widgets) {
//            if(w.getTopicId().equals(topicId)){
//                ws.add(w);
//            }
//        }
//        return ws;
    }

    public Widget createWidget(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        if(widget.getWidgetOrder() == null){
            widget.setWidgetOrder((int) widgetRepository.count());
        }
        if(widget.getText() == null){
            widget.setText("");
        }
        widget.setHeight(200);
        widget.setWidth(300);
        return widgetRepository.save(widget);
//        widget.setId(123);
//        widget.setTopicId(topicId);
//        if(widget.getWidgetOrder() == null){
//            widget.setWidgetOrder((widgets.size()));
//        }
//        if(widget.getText() == null){
//            widget.setText("");
//        }
//        widgets.add(widget);
//        return widget;
    }


    public Widget updateWidget(Integer widgetId, Widget newWidget){
        Optional widgetOptional = widgetRepository.findById(widgetId);
        if (widgetOptional.isPresent()){
            Widget widget = (Widget) widgetOptional.get();
            widget.setAllProperties(newWidget);
            return widgetRepository.save(widget);
        } else {
            return null;
        }

//        for(Widget w:widgets){
//            if (w.getId().equals(widgetId)){
//                w.setText(newWidget.getText());
//                w.setName(newWidget.getName());
//                w.setType(newWidget.getType());
//                w.setSize(newWidget.getSize());
//                w.setEditing(newWidget.isEditing());
//                w.setWidgetOrder(newWidget.getWidgetOrder());
//                return 1;
//            }
//        }
//        return 0;
    }

    public void deleteWidget(Integer wid){
        widgetRepository.deleteById(wid);
//        for(Widget w: widgets){
//            if(w.getId().equals(wid)){
//                widgets.remove(w);
//                return 1;
//            }
//        }
//        return 0;
    }




}
