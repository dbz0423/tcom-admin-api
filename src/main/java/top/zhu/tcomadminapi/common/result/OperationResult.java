package top.zhu.tcomadminapi.common.result;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用操作结果类
 */
@Data
@AllArgsConstructor
@Schema(description = "通用操作结果")
public class OperationResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "操作是否成功")
    private boolean success;

    @Schema(description = "操作信息")
    private String message;

    // 静态工厂方法：成功结果
    public static OperationResult success(String message) {
        return new OperationResult(true, message);
    }

    // 静态工厂方法：失败结果
    public static OperationResult failure(String message) {
        return new OperationResult(false, message);
    }
}
