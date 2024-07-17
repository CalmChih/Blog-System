package top.fallingintodreams.blog.system.services;


import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.po.User;

import java.util.Map;

/**
 *
 * 用户信息 服务接口类
 *
 * @author Chih
 * @date 2024/2/25 19:55
 */
public interface UserService {
    
    ApiResponse registerUser(User user);
    
    ApiResponse getUserInfo();
    
    ApiResponse login(User user);
    
}
