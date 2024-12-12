package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 删除题目请求类
 */
@Data
public class DeleteQuestionRequest {
    @Schema(description = "题库表主键", example = "1")
    private Integer pkId;//条件查询中带一个题库主键用于删除
}
