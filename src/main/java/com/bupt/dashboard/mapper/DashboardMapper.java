package com.bupt.dashboard.mapper;

import com.bupt.dashboard.entity.Dashboard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DashboardMapper {

    @Insert("INSERT INTO dashboard (tenant_id, customer_id, name) " + "VALUES (#{tenant_id}, #{customer_id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int addDashboard(Dashboard dashboard);

    @Delete("DELETE FROM dashboard")
    void removeAllDashboard();

    @Delete("DELETE FROM dashboard WHERE id = #{id}")
    void removeDashboardById(@Param("id") Integer id);

    @Select("SELECT * FROM dashboard")
    List<Dashboard> getDashboards();

    @Select("SELECT * FROM dashboard WHERE id = #{id}")
    Dashboard getDashboardById(@Param("id") Integer id);
}
