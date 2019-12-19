package com.spring.providertwo.controll;

import com.spring.providertwo.entity.AdminUser;
import com.spring.providertwo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class AdminControl {
    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/add")
    public String addUser(AdminUser user) {
        if (user != null) {
            iUserService.insertAdmin(user);
            return "success";
        } else {
            return "error";
        }
    }
    //测试方法，返回服务器端口，以判断是访问哪个服务
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam(value ="name", defaultValue ="zhangsan") String name) {
        return "hi " + name +" ,i am from port:" +port;
    }

}