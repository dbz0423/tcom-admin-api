package top.zhu.tcomadminapi.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import top.zhu.tcomadminapi.model.entity.Manager;

import java.util.List;

public interface ManagerMapper extends BaseMapper<Manager> {

    default Manager getManagerByAccount(String account) {
        return this.selectOne(new LambdaQueryWrapper<Manager>().eq(Manager::getAccount, account));
    }

    List<Manager> selectAllManagers();
}
