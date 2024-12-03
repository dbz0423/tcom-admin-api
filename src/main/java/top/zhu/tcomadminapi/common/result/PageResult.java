package top.zhu.tcomadminapi.common.result;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResult<T> {

    private List<T> data;  // 当前页的数据
    private long total;    // 总记录数

}
