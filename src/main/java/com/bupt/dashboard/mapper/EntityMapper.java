package com.bupt.dashboard.mapper;

import com.bupt.dashboard.entity.Entity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EntityMapper {

    @Insert("INSERT INTO widget_entity (dashboard_id, device_id, name, entity_type, position) " +
            "VALUES (#{dashboard_id}, #{device_id}, #{name}, #{entity_type}, #{position})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addEntity(Entity entity);

    @Delete("DELETE FROM widget_entity")
    void removeAllEntity();

    @Delete("DELETE FROM widget_entity WHERE id = #{id}")
    void removeEntityById(@Param("id") Integer id);

    @Select("SELECT * FROM widget_entity")
    List<Entity> getAllEntity();

    @Select("SELECT * FROM widget_entity WHERE id = #{id}")
    Entity getEntityById(@Param("id") Integer id);

    @Select("SELECT * FROM widget_entity WHERE entity_type = #{entity_type}")
    List<Entity> getEntityByType(@Param("entity_type") String entity_type);

    @Select("SELECT * FROM widget_entity WHERE dashboard_id = #{dashboard_id}")
    List<Entity> getEntityByDashboard(@Param("dashboard_id") Integer dashboard_id);

}
