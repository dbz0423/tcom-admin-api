package top.zhu.tcomadminapi.common.result;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 专用于前端的分页结果类
 * @param <T> 数据类型
 */
@Data
@Schema(description = "专用于前端的题库分页数据")

public class QuestionPageResult<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "当前页的数据列表")
    private List<T> records; // 当前页数据列表

    @Schema(description = "总记录数")
    private long total; // 总记录数

    // 可选：当前页码和每页大小，方便前端分页控制
    @Schema(description = "当前页码")
    private int page;

    @Schema(description = "每页大小")
    private int size;

    /**
     * 构造函数
     * @param records 当前页的数据列表
     * @param total 总记录数
     * @param page 当前页码
     * @param size 每页大小
     */
    public QuestionPageResult(List<T> records, long total, int page, int size) {
        this.records = records;
        this.total = total;
        this.page = page;
        this.size = size;
    }
}
