package com.spring.providertwo.service;

import com.spring.providertwo.dao.AdminUserMapper;
import com.spring.providertwo.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public int insertAdmin(AdminUser adminUser) {
        adminUserMapper.insertAdmin(adminUser);
        return 0;
    }
}
