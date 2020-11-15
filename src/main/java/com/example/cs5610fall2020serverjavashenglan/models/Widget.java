package com.example.cs5610fall2020serverjavashenglan.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String topicId;
    private Integer widgetOrder;
    private String text;
    private String src;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;
    private boolean editing;
    private boolean ordered;

    public Widget(Integer id, String name, String type, String topicId, Integer widgetOrder, String text,
                  String src, Integer size, Integer width, Integer height, String cssClass, String style,
                  String value, boolean editing, boolean ordered) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.topicId = topicId;
        this.widgetOrder = widgetOrder;
        this.text = text;
        this.src = src;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
        this.editing = editing;
        this.ordered = ordered;
    }

    public Widget() {
    }

    public void setAllProperties(Widget newWidget){
        this.setText(newWidget.getText());
        this.setName(newWidget.getName());
        this.setType(newWidget.getType());
        this.setSrc(newWidget.getSrc());
        this.setSize(newWidget.getSize());
        this.setEditing(newWidget.isEditing());
        this.setWidgetOrder(newWidget.getWidgetOrder());
        this.setOrdered(newWidget.isOrdered());
        this.setWidth(newWidget.getWidth());
        this.setHeight(newWidget.getHeight());
    }


    public Integer getId() {
        return id;
    }

    public String getTopicId() {
        return topicId;
    }

    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTopicId(String id) {
        this.topicId = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }
}
