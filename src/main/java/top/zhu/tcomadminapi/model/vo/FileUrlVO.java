package top.zhu.tcomadminapi.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author mqxu
 * @date 2024/11/18
 * @description FileUrlVO
 **/
@Data
@Schema(description = "图片url上传地址")
@AllArgsConstructor
public class FileUrlVO {

    @Schema(description = "file_url")
    private String fileUrl;
}
