package top.zhu.tcomadminapi.service;

import org.springframework.web.multipart.MultipartFile;

import top.zhu.tcomadminapi.model.vo.FileUrlVO;

import java.io.IOException;
import java.util.List;

public interface CommonService {
    /**
     * 图片上传
     *
     * @param uploadFile 上传文件
     * @return 上传文件返回视图
     */
    FileUrlVO upload(MultipartFile uploadFile);

    String upload(MultipartFile file);
    List<String> uploadPdf(MultipartFile file) throws IOException;

}
