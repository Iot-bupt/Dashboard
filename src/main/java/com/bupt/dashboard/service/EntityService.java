package com.bupt.dashboard.service;

import com.bupt.dashboard.entity.Entity;
import com.bupt.dashboard.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityService {

    @Autowired
    EntityMapper entityMapper;

    public Entity insertEntity(Entity entity){
        this.entityMapper.addEntity(entity);
        return entity;
    }

    public void updateEntity(Entity entity){
        entityMapper.updateEntity(entity.getId(), entity.getDiffX(), entity.getDiffY(), entity.getName());
    }

    public List<Entity> getAllEntity(){
        return this.entityMapper.getAllEntity();
    }

    public List<Entity> getEntityByType(String entity_type){
        return this.entityMapper.getEntityByType(entity_type);
    }

    public Entity getEntityById(Integer id){
        return this.entityMapper.getEntityById(id);
    }

    public void removeAllEntity(){
        this.entityMapper.removeAllEntity();
    }

    public void removeEntityById(Integer id){
        this.entityMapper.removeEntityById(id);
    }

    public List<Entity> getByDashboard(Integer dashboard_id){
        return this.entityMapper.getEntityByDashboard(dashboard_id);
    }
}
