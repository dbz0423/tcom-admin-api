package top.zhu.tcomadminapi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.UserMapper;
import top.zhu.tcomadminapi.model.entity.User;
import top.zhu.tcomadminapi.service.UserService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 新增用户
    @Override
    public boolean addUser(User user) {
        return this.save(user);
    }

    // 删除用户
    @Override
    public boolean deleteUser(Long pkId) {
        return this.removeById(pkId);
    }

    @Override
    public boolean updateUser(User user) {
        // 设置更新时间为当前时间
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));

        // 如果 createTime 为空，则不做处理或者设置为当前时间
        if (user.getCreateTime() == null) {
            user.setCreateTime(new Timestamp(System.currentTimeMillis())); // 也可以不修改，保留原值
        }

        return this.updateById(user);
    }


    // 根据 ID 查询用户
    @Override
    public User getUserById(Long pkId) {
        return this.getById(pkId);
    }

    // 查询所有用户
    @Override
    public List<User> getAllUsers() {
        return this.list();
    }

    // 根据条件查询用户
    @Override
    public List<User> searchUsers(String nickname, String phone, Integer role) {
        // 这里可以使用 MyBatis-Plus 的条件构造器（QueryWrapper）进行条件查询
        return this.list(new QueryWrapper<User>()
                .like(nickname != null, "nickname", nickname)
                .like(phone != null, "phone", phone)
                .eq(role != null, "role", role));
    }


    // 分页查询用户
    @Override
    public Page<User> getUserPage(int pageNum, int pageSize, String nickname, String phone, Integer role) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);

        // 创建查询条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (nickname != null) {
            wrapper.like("nickname", nickname);
        }
        if (phone != null) {
            wrapper.eq("phone", phone);
        }
        if (role != null) {
            wrapper.eq("role", role);
        }

        // 分页查询
        return userMapper.selectPage(page, wrapper);
    }


}
