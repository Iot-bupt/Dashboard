package com.bupt.dashboard.controller;

import com.bupt.dashboard.entity.Dashboard;
import com.bupt.dashboard.service.DashboardService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'insertDashboard')")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Dashboard insertDashboard(@RequestBody String dashboard){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(dashboard);
        Dashboard addDashboard = new Dashboard(jsonObj);
        Dashboard insertDashboard = dashboardService.insertDashboard(addDashboard);

        return insertDashboard;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getDashboardById')")
    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public Dashboard getDashboardById(@PathVariable("id") Integer id){
        Dashboard dashboard = dashboardService.getDashboardById(id);
        return dashboard;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'getDashboards')")
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Dashboard> getDashboards(){
        List<Dashboard> dashboards = dashboardService.getDashboards();
        return dashboards;
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'removeAllDashboard')")
    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAllDashboard(){
        dashboardService.removeAllDashboard();
    }

    @PreAuthorize("#oauth2.hasScope('all') OR hasPermission(null ,'removeDashboardById')")
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeDashboardById(@PathVariable("id") Integer id){
        dashboardService.removeDashboardById(id);
    }
}
