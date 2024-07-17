package top.fallingintodreams.blog.system.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fallingintodreams.blog.system.po.User;

@Mapper
public interface IUserDao {
    
    void insertUser(User user);
    
    User getUser(User user);
    
}