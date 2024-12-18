package top.zhu.tcomadminapi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface CommonService {
    String upload(MultipartFile file);
    List<String> uploadPdf(MultipartFile file) throws IOException;

}
