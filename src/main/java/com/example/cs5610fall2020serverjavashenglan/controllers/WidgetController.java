package com.example.cs5610fall2020serverjavashenglan.controllers;

import com.example.cs5610fall2020serverjavashenglan.models.Widget;
import com.example.cs5610fall2020serverjavashenglan.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findAllWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Integer widgetId) {
        return service.findWidgetById(widgetId);
    }

    @GetMapping("/api/widgets")
    public List<Widget>findAllWidgets(){
        return service.findAllWidgets();
    }

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
            @PathVariable("topicId") String topicId,
            @RequestBody Widget widget) {
        return service.createWidget(topicId, widget);
    }

    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
            @PathVariable("wid") Integer widgetId,
            @RequestBody Widget newWidget){
        return service.updateWidget(widgetId, newWidget);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(
            @PathVariable("wid") Integer wid){
        service.deleteWidget(wid);
    }
}
