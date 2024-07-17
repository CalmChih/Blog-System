package top.fallingintodreams.blogsystem.dao;

import org.apache.ibatis.annotations.Mapper;
import top.fallingintodreams.flying.bicycle.backend.dto.UserAccountDTO;
import top.fallingintodreams.flying.bicycle.backend.po.UserAccount;

import java.util.Map;

/**
 * 用户账户表Dao
 *
 * @author Chih
 * @date 2024/2/25 19:36
 */
@Mapper
public interface IArticleDao {
    /**
     * 插入用户账户信息
     * @param userAccount 用户账户信息
     */
    void insertUserAccount(UserAccount userAccount);

    /**
     * 获取账户id
     * @param userAccountDTO 登录信息
     * @return 账户id
     */
    UserAccount getPassword(UserAccountDTO userAccountDTO);

    void updatePassword(UserAccountDTO userAccountDTO);

    void updateAccountState(Map<String, Object> searchMap);
}
