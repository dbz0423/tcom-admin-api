package top.zhu.tcomadminapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zhu.tcomadminapi.model.entity.City;

@Mapper
public interface CityMapper extends BaseMapper<City> {
    // 基本的CRUD方法都已由 BaseMapper 提供，无需手动写
}

