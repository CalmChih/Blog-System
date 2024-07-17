package top.fallingintodreams.blog.system.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallingintodreams.blog.system.common.ApiResponse;
import top.fallingintodreams.blog.system.po.User;
import top.fallingintodreams.blog.system.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Resource
    private UserService userService;

    @SaCheckLogin
    @GetMapping("/me")
    public ApiResponse getUserInfo() {
        return userService.getUserInfo();
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/register")
    public ApiResponse updatePassword(@RequestBody User user) {
        return userService.registerUser(user);
    }
    
}
