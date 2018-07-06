package com.bupt.dashboard.controller;


import com.bupt.dashboard.entity.Entity;
import com.bupt.dashboard.service.EntityService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard/entity")
public class EntityController {

    @Autowired
    EntityService entityService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertEntity(@RequestBody String entity){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(entity);
        Entity addEntity = new Entity(jsonObj);
        Entity insertEntity = entityService.insertEntity(addEntity);

        return insertEntity.toString();
    }

    @RequestMapping(value = "/{entity_type}", method = RequestMethod.GET)
    public List<Entity> getEntityByType(@PathVariable("dataType") String dataType){
        List<Entity> entities = entityService.getEntityByType(dataType);
        return entities;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Entity getEntityById(@PathVariable("id") Integer id){
        Entity entity = entityService.getEntityById(id);
        return entity;
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAllEntity(){
        entityService.removeAllEntity();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeEntity(@PathVariable("id") Integer id){
        entityService.removeEntityById(id);
    }
}
