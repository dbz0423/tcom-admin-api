package top.zhu.tcomadminapi.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 考核概览 DTO
 */
@Data
@Schema(description = "考核概览 DTO")
public class QuizDTO {

    @Schema(description = "主键唯一字段", example = "1")
    private Integer pkId;

    @Schema(description = "考核标题", example = "考核标题示例")
    private String title;

    @Schema(description = "考核简介", example = "这是一段简短的考核简介")
    private String brief;

    @Schema(description = "考核封面", example = "https://example.com/images/cover.jpg")
    private String cover;

    @Schema(description = "证书背景", example = "https://example.com/images/certificate.jpg")
    private String certificateUrl;

    @Schema(description = "创建时间", example = "2024-12-15 12:00:00")
    private Timestamp createTime;
}