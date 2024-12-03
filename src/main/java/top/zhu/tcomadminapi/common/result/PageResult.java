package top.zhu.tcomadminapi.common.result;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageResult<T> {
    // Getters and Setters
    private long total;     // 总记录数
    private List<T> records;  // 当前页的数据

    public PageResult(long total, List<T> records) {
        this.total = total;
        this.records = records;
    }

}