package top.zhu.tcomadminapi.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Schema(description = "分页数据")
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "总记录数")
    private int total1;

    @Schema(description = "列表数据")
    private List<T> list;

    private List<T> data;  // 当前页的数据
    
    private long total;    // 总记录数
    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }
}

