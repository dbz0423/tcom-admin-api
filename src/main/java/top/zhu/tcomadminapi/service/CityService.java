package top.zhu.tcomadminapi.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.zhu.tcomadminapi.mapper.CityMapper;
import top.zhu.tcomadminapi.model.entity.City;

import java.util.List;

@Service
public class CityService extends ServiceImpl<CityMapper, City> {

    /**
     * 获取所有省级城市
     */
    public List<City> getProvinces() {
        // 使用 MyBatis-Plus 的 QueryWrapper 来筛选省级城市
        return this.list(new QueryWrapper<City>().eq("level", 1));
    }

    /**
     * 根据省级城市 pkId 获取市级城市列表
     */
    public List<City> getCitiesByProvinceId(Long provinceId) {
        // 使用 MyBatis-Plus 的 QueryWrapper 来筛选市级城市
        return this.list(new QueryWrapper<City>().eq("level", 2).eq("parent_code", provinceId));
    }

    /**
     * 根据市级城市 pkId 获取区级城市列表
     */
    public List<City> getAreasByCityId(Long cityId) {
        // 使用 MyBatis-Plus 的 QueryWrapper 来筛选区级城市
        return this.list(new QueryWrapper<City>().eq("level", 3).eq("parent_code", cityId));
    }

    /**
     * 获取所有城市按层级排序
     */
    public List<City> getAllCity() {
        // 获取所有城市并按 level 排序
        return this.list(new QueryWrapper<City>().orderByAsc("level"));
    }
}
