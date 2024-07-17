package top.fallingintodreams.blog.system.services.impl;


import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.dao.IUserDao;
import top.fallingintodreams.blog.system.po.User;
import top.fallingintodreams.blog.system.services.UserService;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    
    @Resource
    private IUserDao userDao;
    
    @Override
    public ApiResponse registerUser(User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return ApiResponse.error("用户名或密码不能为空");
        }
        User userInfo = userDao.getUser(user);
        if (Objects.nonNull(userInfo)) {
            return ApiResponse.error("用户名已存在");
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userDao.insertUser(user);
        return ApiResponse.success("注册成功");
    }
    
    @Override
    public ApiResponse getUserInfo() {
        long userId = StpUtil.getLoginIdAsLong();
        User user = new User();
        user.setUserId(userId);
        User res = userDao.getUser(user);
        return ApiResponse.success(res);
    }
    
    @Override
    public ApiResponse login(User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return ApiResponse.error("用户名或密码不能为空");
        }
        User userInfo = userDao.getUser(user);
        if (Objects.isNull(userInfo)) {
            return ApiResponse.error("用户名不存在");
        }
        if (!BCrypt.checkpw(user.getPassword(), userInfo.getPassword())) {
            return ApiResponse.error("密码错误");
        }
        StpUtil.login(userInfo.getUserId());
        return ApiResponse.success("登录成功");
    }
    
}
