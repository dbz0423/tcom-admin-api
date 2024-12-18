package top.zhu.tcomadminapi.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zhu.tcomadminapi.common.result.Result;

import top.zhu.tcomadminapi.model.vo.FileUrlVO;
import top.zhu.tcomadminapi.service.CommonService;

import java.io.IOException;
import java.util.List;

@Tag(name = "通用模块")
@RestController
@RequestMapping("v1/api/common")
@AllArgsConstructor
public class CommonController {

    private final CommonService commonService;


    @PostMapping(value = "/upload/pfImg")
    @ResponseBody
    @Operation(summary = "图片上传")
    public Result<FileUrlVO> upload(@RequestBody MultipartFile file) {
        return Result.ok(commonService.upload(file));
    }


    @PostMapping( "/upload/img")
    @Operation(summary = "图片上传")
    public Result<String> upload(@RequestBody MultipartFile file) {
        return Result.ok(commonService.upload(file));
    }


    @PostMapping( "/upload/pdf")
    @Operation(summary = "pdf文件上传")
    public Result<List<String>> uploadPdf(@RequestParam MultipartFile file) throws IOException {
        return Result.ok(commonService.uploadPdf(file));
    }

}

