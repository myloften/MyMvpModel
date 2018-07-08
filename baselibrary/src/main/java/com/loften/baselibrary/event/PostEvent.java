package com.loften.baselibrary.event;


/**
 * 事件传递数据
 */
public class PostEvent {

    private int EventType;
    private Object object;

    public PostEvent(int eventType, Object object) {
        EventType = eventType;
        this.object = object;
    }

    public PostEvent() {
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
