package top.zhu.tcomadminapi.model.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Data
public class QuestionVO {
    private String question;  // 题目内容
    private String type;      // 题目类型（中文）
    private List<String> options;  // 选项（内容+详细描述）
    private String answer;    // 题目答案
    private String createTime;  // 创建时间（格式化）

    // Getters and Setters
}
