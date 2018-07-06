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
}
