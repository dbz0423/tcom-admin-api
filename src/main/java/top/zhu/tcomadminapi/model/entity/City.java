package top.zhu.tcomadminapi.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_city_code")
public class City {

    @TableId(value = "pk_id",type = IdType.AUTO) // 主键策略
    private Long pkId;

    private String code; // 城市编码

    private String name; // 城市名称

    private String parentCode; // 上级城市编码

    private Integer level; // 1: 省, 2: 市, 3: 区县

}
