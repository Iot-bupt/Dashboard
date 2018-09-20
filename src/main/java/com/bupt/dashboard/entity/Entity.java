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
    private String diffX;
    private String diffY;


    public Entity(Integer id, Integer dashboard_id, String device_id, String name, String entity_type, String diffX, String diffY){
        this.id = id;
        this.dashboard_id = dashboard_id;
        this.device_id = device_id;
        this.name = name;
        this.entity_type = entity_type;
        this.diffX = diffX;
        this.diffY = diffY;

    }

    public Entity(JsonObject jsonObject){
        this.dashboard_id = jsonObject.get("dashboard_id").getAsInt();
        this.device_id = jsonObject.get("device_id").getAsString();
        this.name = jsonObject.get("name").getAsString();
        this.entity_type = jsonObject.get("entity_type").getAsString();
        this.diffX = jsonObject.get("diffX").getAsString();
        this.diffY = jsonObject.get("diffY").getAsString();
    }

    public Entity(JsonObject updataJsonObject, Integer id){
        this.id = id;
        this.dashboard_id = updataJsonObject.get("dashboard_id").getAsInt();
        this.device_id = updataJsonObject.get("device_id").getAsString();
        this.name = updataJsonObject.get("name").getAsString();
        this.entity_type = updataJsonObject.get("entity_type").getAsString();
        this.diffX = updataJsonObject.get("diffX").getAsString();
        this.diffY = updataJsonObject.get("diffY").getAsString();
    }
}
