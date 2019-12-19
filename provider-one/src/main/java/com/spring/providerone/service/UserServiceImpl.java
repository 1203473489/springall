package com.spring.providerone.service;

import com.spring.providerone.control.AdminUserControl;
import com.spring.providerone.dao.AdminUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserServiceImpl implements IUserService {
    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public int insertAdmin(AdminUserControl adminUser) {
        adminUserMapper.insertAdmin(adminUser);
        return 0;
    }
}
