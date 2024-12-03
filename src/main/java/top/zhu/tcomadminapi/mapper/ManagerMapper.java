package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zhu.tcomadminapi.model.entity.Manager;

@Mapper
public interface ManagerMapper extends BaseMapper<Manager> {
    // 可以在这里添加自定义查询方法
}
