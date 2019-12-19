package com.spring.consumerribbon.contoller;

import com.spring.consumerribbon.entity.AdminUser;
import com.spring.consumerribbon.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AdminUserControl {
    @Autowired
    private Service service;
    @RequestMapping(value ="/hi")
    public String hi(@RequestParam String name){
        AdminUser adminUser = new AdminUser();
        adminUser.setAdminId("1");
        adminUser.setAdminName("张三");
        adminUser.setAdminNo("11");
        adminUser.setCreateTime(new Date());
        adminUser.setLoginPass("123");
        adminUser.setStatus("1");
        return service.hiService(name);
    }

}
