package com.bupt.dashboard.controller;


import com.bupt.dashboard.entity.Entity;
import com.bupt.dashboard.service.EntityService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard/entity")
public class EntityController {

    @Autowired
    EntityService entityService;

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'insertEntity')")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Entity insertEntity(@RequestBody String entity){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(entity);
        Entity addEntity = new Entity(jsonObj);
        Entity insertEntity = entityService.insertEntity(addEntity);

        return insertEntity;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'updateEntity')")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateEntity(@RequestBody String entity){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(entity);
        Integer id = jsonObj.get("id").getAsInt();
        Entity addEntity = new Entity(jsonObj, id);
        entityService.updateEntity(addEntity);
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getAllEntity')")
    @RequestMapping(value = "/getAllEntity", method = RequestMethod.GET)
    public List<Entity> getAllEntity(){
        List<Entity> entities = entityService.getAllEntity();
        return entities;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getAllEntityByDashboardId')")
    @RequestMapping(value = "/getByDashboardId/{dashboardId}", method = RequestMethod.GET)
    public List<Entity> getAllEntityByDashboardId(@PathVariable("dashboardId") Integer dashboardId){
        List<Entity> entities = entityService.getByDashboard(dashboardId);
        return entities;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getEntityByType')")
    @RequestMapping(value = "/getByType/{entity_type}", method = RequestMethod.GET)
    public List<Entity> getEntityByType(@PathVariable("entity_type") String entity_type){
        List<Entity> entities = entityService.getEntityByType(entity_type);
        return entities;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getEntityById')")
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public Entity getEntityById(@PathVariable("id") Integer id){
        Entity entity = entityService.getEntityById(id);
        return entity;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'removeAllEntity')")
    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAllEntity(){
        entityService.removeAllEntity();
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'removeEntity')")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeEntity(@PathVariable("id") Integer id){
        entityService.removeEntityById(id);
    }
}
