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
    private Integer optionType;      // 题目类型（0单选，1多选，2填空）
    private List<String> options;  // 选项（选项内容option+详细描述content）
    private String answer;    // 题目答案
    private String createTime; // 创建时间（格式化）
    private Integer pkId;  //删除方法用的主键
    // Getters and Setters
}
