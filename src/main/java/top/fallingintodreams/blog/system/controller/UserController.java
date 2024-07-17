package top.fallingintodreams.blogsystem.controller;

import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.fallingintodreams.blogsystem.common.ApiResponse;
import top.fallingintodreams.blogsystem.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserAccountService userAccountService;

    @GetMapping("/me")
    public ApiResponse getUserInfo() {
        String username = StpUtil.getLoginIdAsString();
        User userInfo = userService.getUserInfo(username);
        return ApiResponse.success(userInfo);
    }

    @PostMapping("/login")
    public ApiResponse updateUserInfo(@RequestBody User user) {
        userService.updateUserInfo(user);
        return ApiResponse.success("更新成功");
    }

    @PostMapping("/register")
    public ApiResponse updatePassword(@RequestBody UserAccountDTO userAccountDTO) {
        userAccountService.updatePassword(userAccountDTO);
        return ApiResponse.success("更新成功");
    }
    
}
