package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.zhu.tcomadminapi.model.entity.User;

import java.util.List;

/**
 * 用户服务接口
 */
public interface UserService extends IService<User> {

    // 新增用户
    boolean addUser(User user);

    // 删除用户
    boolean deleteUser(Long pkId);

    // 更新用户信息
    boolean updateUser(User user);

    // 根据 ID 查询用户
    User getUserById(Long pkId);

    // 查询所有用户
    List<User> getAllUsers();

    // 根据条件查询用户
    List<User> searchUsers(String nickname, String phone, Integer role);

    // 分页查询用户
    Page<User> getUserPage(int pageNum, int pageSize, String nickname, String phone, Integer role);

}




