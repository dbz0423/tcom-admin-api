package top.zhu.tcomadminapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zhu.tcomadminapi.common.result.Result;
import top.zhu.tcomadminapi.model.vo.FileUrlVO;
import top.zhu.tcomadminapi.service.CommonService;

/**
 * @author mqxu
 * @date 2024/11/18
 * @description CommonController
 **/
@Tag(name = "通用模块")
@RestController
@RequestMapping("/v1/common")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;

    @PostMapping(value = "/upload/img")
    @ResponseBody
    @Operation(summary = "图片上传")
    public Result<FileUrlVO> upload(@RequestBody MultipartFile file) {
        return Result.ok(commonService.upload(file));
    }
}