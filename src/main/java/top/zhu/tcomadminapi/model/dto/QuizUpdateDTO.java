package top.zhu.tcomadminapi.model.dto;

import lombok.Data;

@Data
public class QuizUpdateDTO {
    private Integer pkId; // 主键ID
    private String title; // 标题
    private String brief; // 简介
    private String cover; // 封面图片URL
    private String certificateUrl; // 证书背景URL
}