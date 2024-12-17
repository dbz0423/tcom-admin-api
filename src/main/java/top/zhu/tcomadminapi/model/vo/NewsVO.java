package top.zhu.tcomadminapi.model.vo;

import lombok.Data;
import org.w3c.dom.Text;

@Data
public class NewsVO {

    private Integer pkId;            // 资讯ID

    private String title;            // 标题

    private String cover;            // 封面

    private String source;           // 来源

    private String label;            // 标签

    private String content;

    private Integer state;

}
