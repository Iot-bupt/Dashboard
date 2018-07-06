package com.bupt.dashboard.mapper;

import com.bupt.dashboard.entity.Entity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EntityMapper {

    @Insert("INSERT INTO entity (dashboard_id, device_id, name, entity_type, startTime, endTime) " +
            "VALUES (#{dashboard_id}, #{device_id}, #{name}, #{entity_type}, #{startTime}, #{endTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addEntity(Entity entity);

    @Delete("DELETE FROM entity")
    void removeAllEntity();

    @Delete("DELETE FROM entity WHERE id = #{id}")
    void removeEntityById(@Param("id") Integer id);

    @Select("SELECT * FROM entity WHERE id = #{id}")
    Entity getEntityById(@Param("id") Integer id);

    @Select("SELECT * FROM  entity WHERE entity_type = #{entity_type}")
    List<Entity> getEntityByType(@Param("entity_type") String entity_type);

}
