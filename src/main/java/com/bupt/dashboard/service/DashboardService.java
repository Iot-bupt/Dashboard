package com.bupt.dashboard.service;

import com.bupt.dashboard.entity.Dashboard;
import com.bupt.dashboard.mapper.DashboardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    DashboardMapper dashboardMapper;

    public Dashboard insertDashboard(Dashboard dashboard){
        this.dashboardMapper.addDashboard(dashboard);
        return dashboard;
    }

    public List<Dashboard> getDashboards(){
        return this.dashboardMapper.getDashboards();
    }

    public Dashboard getDashboardById(Integer id){
        return this.dashboardMapper.getDashboardById(id);
    }

    public void removeAllDashboard(){
        this.dashboardMapper.removeAllDashboard();
    }

    public void removeDashboardById(Integer id){
        this.dashboardMapper.removeDashboardById(id);
    }
}
