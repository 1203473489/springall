package com.spring.providertwo.service;

import com.spring.providertwo.dao.AdminUserMapper;
import com.spring.providertwo.entity.AdminUser;

public interface IUserService {
    public int insertAdmin(AdminUser adminUser);
}
