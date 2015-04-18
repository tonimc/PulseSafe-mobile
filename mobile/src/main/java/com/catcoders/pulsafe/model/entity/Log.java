package com.catcoders.pulsafe.model.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by tonimc on 17/4/15.
 */
public class Log {

    private String dateTime;
    private String typeLog;
    private int id;
    private String value;
    private String user;
    private String location;

    public Log(String dateTime, String typeLog, int id, String value, String user, String location) {
        this.dateTime = dateTime;
        this.typeLog = typeLog;
        this.id = id;
        this.value = value;
        this.user = user;
        this.location = location;
    }

    protected Log() {

    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTypeLog() {
        return typeLog;
    }

    public void setTypeLog(String typeLog) {
        this.typeLog = typeLog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static Log jsonDeserialized(String json) {
        Log log = new Log();
        try {
            JSONObject jsonObject = new JSONObject(json);

            JSONObject value = jsonObject.getJSONObject("value");
            log.setId(jsonObject.getInt("id"));
            log.setUser(jsonObject.getString("name"));
            log.setTypeLog(jsonObject.getString("type_log"));
            log.setDateTime(jsonObject.getString("datatime"));
            log.setValue(jsonObject.getString("BPM"));
            log.setLocation(jsonObject.getString("location"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return log;
    }

    public static String jsonSerialized(Log log) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", log.getId());
            jsonObject.put("name", log.getUser());
            jsonObject.put("datatime", log.getDateTime());
            jsonObject.put("type_log", log.getTypeLog());
            JSONObject valueObject = new JSONObject();
            valueObject.put("location", log.getLocation());
            valueObject.put("BPM", log.getValue());
            jsonObject.put("value", valueObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
