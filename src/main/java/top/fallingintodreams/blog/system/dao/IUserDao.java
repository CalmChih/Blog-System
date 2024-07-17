package top.fallingintodreams.blogsystem.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fallingintodreams.flying.bicycle.backend.po.User;
import top.fallingintodreams.flying.bicycle.backend.vo.UserInfoVO;

import java.util.List;
import java.util.Map;

@Mapper
public interface IUserDao {
    
    void insertUser(User user);
    
    User getUser(Long userId);

    User updateUserInfo(User user);

    List<UserInfoVO> getUserList(Map<String, Object> searchMap);

    void updateUserState(Map<String, Object> searchMap);

}