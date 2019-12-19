package com.spring.consumerribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.spring.consumerribbon.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * PROVIDER-USER为注册服务里的名称，用来代替具体的URL，来调用/user/hi接口，
 * RestTemplate详解，有兴趣可以看看：https://my.oschina.net/u/3177357/blog/2239749
 */
@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private RestTemplate restTemplate;
    public String hiService(String name) {
        return restTemplate.postForObject("http://PROVIDER-USER/admin/hi?name="+name,null,String.class);
    }
    @HystrixCommand(fallbackMethod ="userListError")
    public String addUser(AdminUser adminUser) {
        return restTemplate.postForEntity("http://PROVIDER-USER/user/add",adminUser,String.class).getBody();
    }
    @HystrixCommand(fallbackMethod ="updateUserError")
    public String updateUser(AdminUser user){
        return restTemplate.postForEntity("http://PROVIDER-USER/user/updateUser",user,String.class).getBody();
    }
    @HystrixCommand(fallbackMethod ="delUserError")
    public String delUser(String id){
        return restTemplate.postForObject("http://PROVIDER-USER/user/delUser?id="+id,null,String.class);
    }
    public String hiError(String  name) {
        return "服务器开了小差，请休息一会再试！";
    }
    public List userListError() {
        return null;
    }
    public String addUserError(AdminUser user){return "服务器开了小差，请休息一会再试！";}
    public String updateUserError(AdminUser user){return "服务器开了小差，请休息一会再试！";}
    public String delUserError(String id){return "服务器开了小差，请休息一会再试！";}


}
