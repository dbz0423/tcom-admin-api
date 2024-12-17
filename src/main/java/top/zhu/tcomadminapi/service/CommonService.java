package top.zhu.tcomadminapi.service;

import org.springframework.web.multipart.MultipartFile;
import top.zhu.tcomadminapi.model.vo.FileUrlVO;


/**
 * @author mqxu
 * @date 2024/11/18
 * @description CommonService
 **/
public interface CommonService {
    /**
     * 图片上传
     *
     * @param uploadFile 上传文件
     * @return 上传文件返回视图
     */
    FileUrlVO upload(MultipartFile uploadFile);
}
