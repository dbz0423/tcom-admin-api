package top.zhu.tcomadminapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.zhu.tcomadminapi.model.entity.City;
import top.zhu.tcomadminapi.service.CityService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 城市管理
 */
@RestController
@RequestMapping("/v1/city")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 获取所有城市列表
     */
    @GetMapping("/list")
    public ResponseEntity<List<City>> getCityList() {
        List<City> cityList = cityService.list(); // 使用 MyBatis-Plus 的 list() 方法
        return ResponseEntity.ok(cityList);
    }

    /**
     * 根据城市编码获取城市信息
     *
     * @param code 城市编码
     */
    @GetMapping("/{code}")
    public ResponseEntity<City> getCityByCode(@PathVariable("code") String code) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", code); // 通过城市编码查询
        City city = cityService.getOne(queryWrapper); // 使用 MyBatis-Plus 的 getOne 方法
        if (city == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }

    /**
     * 根据省级城市 code 获取市级城市列表
     *
     * @param provinceCode 省级城市的 code
     */
    @GetMapping("/cities/{provinceCode}")
    public ResponseEntity<List<City>> getCitiesByProvinceCode(@PathVariable("provinceCode") String provinceCode) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level", 2);  // 只查询市级城市
        queryWrapper.eq("parent_code", provinceCode);  // 根据省级城市的 code 作为 parent_code
        List<City> cityList = cityService.list(queryWrapper);
        return ResponseEntity.ok(cityList);  // 返回市级城市列表
    }

    /**
     * 根据市级城市 code 获取区级城市列表
     *
     * @param cityCode 市级城市的 code
     */
    @GetMapping("/areas/{cityCode}")
    public ResponseEntity<List<City>> getAreasByCityCode(@PathVariable("cityCode") String cityCode) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("level", 3);  // 只查询区级城市
        queryWrapper.eq("parent_code", cityCode);  // 根据市级城市的 code 作为 parent_code
        List<City> areaList = cityService.list(queryWrapper);
        return ResponseEntity.ok(areaList);  // 返回区级城市列表
    }

    /**
     * 根据城市 pkId 获取城市名称
     *
     * @param pkId 城市的 pkId
     * @return 返回城市名称
     */
    @GetMapping("/name/{pkId}")
    public ResponseEntity<String> getCityNameById(@PathVariable("pkId") Long pkId) {
        City city = cityService.getById(pkId); // 使用 MyBatis-Plus 的 getById 方法
        if (city == null) {
            return ResponseEntity.notFound().build(); // 如果城市不存在，返回 404 Not Found
        }
        return ResponseEntity.ok(city.getName()); // 返回城市名称
    }


}
