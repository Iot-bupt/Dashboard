package com.bupt.dashboard.entity;
import com.google.gson.JsonObject;
import lombok.Data;

@Data
public class Dashboard {
    private Integer id;
    private Integer tenant_id;
    private Integer customer_id;
    private String name;

    public Dashboard(Integer id, Integer tenant_id, Integer customer_id, String name){
        this.id = id;
        this.tenant_id = tenant_id;
        this.customer_id = customer_id;
        this.name = name;
    }

    public Dashboard(JsonObject jsonObject){
        this.name = jsonObject.get("name").getAsString();
        this.tenant_id = jsonObject.get("tenant_id").getAsInt();
        this.customer_id = jsonObject.get("customer_id").getAsInt();
    }
}
