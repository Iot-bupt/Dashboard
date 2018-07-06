package com.bupt.dashboard.entity;

import com.google.gson.JsonObject;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Entity {

    private Integer id;
    private Integer dashboard_id;
    private String device_id;
    private String name;
    private String entity_type;
    private Long startTime;
    private Long endTime;


    public Entity(Integer id, Integer dashboard_id, String device_id, String name, String entity_type, Long startTime, Long endTime){
        this.id = id;
        this.dashboard_id = dashboard_id;
        this.device_id = device_id;
        this.name = name;
        this.entity_type = entity_type;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public Entity(JsonObject jsonObject){
        this.dashboard_id = jsonObject.get("dashboard_id").getAsInt();
        this.device_id = jsonObject.get("device_id").getAsString();
        this.name = jsonObject.get("name").getAsString();
        this.entity_type = jsonObject.get("entity_type").getAsString();
        this.startTime = jsonObject.get("startTime").getAsLong();
        this.endTime = jsonObject.get("endTime").getAsLong();


    }
}