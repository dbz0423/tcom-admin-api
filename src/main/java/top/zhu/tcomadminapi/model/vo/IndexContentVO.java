package top.zhu.tcomadminapi.model.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Schema(name = "IndexContentVO", description = "首页内容视图对象")
public class IndexContentVO {

    @Schema(description = "唯一标识")
    private Long pkId;  // 首页内容ID

    @Schema(description = "分类ID")
    private Long categoryId;  // 分类ID

    @Schema(description = "内容ID")
    private Long contentId;  // 内容ID

    @Schema(description = "标题")
    private String title;  // 标题

    @Schema(description = "类型")
    private Integer type;  // 类型

    @Schema(description = "创建时间")
    private Timestamp createTime;  // 创建时间

    @Schema(description = "更新时间")
    private Timestamp updateTime;  // 更新时间

    // 根据需要可以添加其他字段或方法
}
