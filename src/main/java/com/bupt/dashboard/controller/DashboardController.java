package com.bupt.dashboard.controller;

import com.bupt.dashboard.entity.Dashboard;
import com.bupt.dashboard.service.DashboardService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Dashboard insertDashboard(@RequestBody String dashboard){

        JsonObject jsonObj = (JsonObject)new JsonParser().parse(dashboard);
        Dashboard addDashboard = new Dashboard(jsonObj);
        Dashboard insertDashboard = dashboardService.insertDashboard(addDashboard);

        return insertDashboard;
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public Dashboard getDashboardById(@PathVariable("id") Integer id){
        Dashboard dashboard = dashboardService.getDashboardById(id);
        return dashboard;
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    public void removeAllDashboard(){
        dashboardService.removeAllDashboard();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void removeAllDashboardById(@PathVariable("id") Integer id){
        dashboardService.removeDashboardById(id);
    }
}
