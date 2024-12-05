package top.zhu.tcomadminapi.model.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.zhu.tcomadminapi.common.model.Query;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
@Schema(name = "IndexContentQuery", description = "首页内容查询参数")
public class IndexContentQuery extends Query {

    @Schema(description = "标题")
    private String title;  // 首页内容标题

    @Schema(description = "分类ID")
    private Long categoryId;  // 分类ID，用于筛选特定分类的首页内容

    @Schema(description = "首页内容类型")
    private Integer type;  // 首页内容类型（如课程、播客、资讯等）

    @Schema(description = "创建时间")
    private Timestamp createTime;  // 首页内容创建时间，用于筛选创建时间范围

    @Schema(description = "更新时间")
    private Timestamp updateTime;  // 首页内容更新时间，用于筛选更新时间范围

}
