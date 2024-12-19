package top.zhu.tcomadminapi.service.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.zhu.tcomadminapi.common.exception.ServerException;
import top.zhu.tcomadminapi.model.vo.FileUrlVO;
import top.zhu.tcomadminapi.service.CommonService;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import top.zhu.tcomadminapi.common.config.OssConfig;


import top.zhu.tcomadminapi.service.PdfService;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@AllArgsConstructor
public class CommonServiceImpl implements CommonService {

    @Resource
    private PdfService pdfService;
    @Resource
    private final OssConfig ossConfig;
    @Resource
    private OSSClient ossClient;

    private static final String[] IMAGE_TYPE = new String[]{".bmp", ".jpg",".jpeg", ".gif", ".png"};
    private static final String IMAGE_TYPE_PDF = new String(".pdf");

    @Value("${aliyun.oss.bucketName}")
    private String bucketName;

  
  
  
 @Override
    public FileUrlVO uploadPf(MultipartFile uploadFile) {

        String returnImgUrl = "";

        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        if (!isLegal) {
            // 如果图片格式不合法
            throw new ServerException("图片格式不正确");
        }

        // 获取文件原名称
        String originalFilename = uploadFile.getOriginalFilename();
        // 获取文件类型
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 新文件名称
        String newFileName = UUID.randomUUID().toString() + fileType;
        // 构建日期路径, 例如：OSS目标文件夹/2020/10/31/文件名
        String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        // 文件上传的路径地址
        String uploadImgeUrl = filePath + "/" + newFileName;

        // 获取文件输入流
        InputStream inputStream = null;
        try {
            inputStream = uploadFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * 现在阿里云OSS 默认图片上传ContentType是image/jpeg
         * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
         * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
         */
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("image/jpg");

        //文件上传至阿里云OSS
        ossClient.putObject(bucketName, uploadImgeUrl, inputStream, meta);
        // 获取文件上传后的图片返回地址
        returnImgUrl = "https://" + bucketName + "." + ossClient.getEndpoint().getHost() + "/" + uploadImgeUrl;
        return new FileUrlVO(returnImgUrl);
    }
      
@Override
    public String upload(MultipartFile file) {
        String returnImgUrl;

        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        if (!isLegal) {
            // 如果图片格式不合法，抛出异常
            throw new ServerException("图片格式不正确");
        }

        // 获取文件原名称
        String originalFilename = file.getOriginalFilename();

        // 获取文件类型，确保原文件名不为空
        assert originalFilename != null;
        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 新文件名称
        String newFileName = UUID.randomUUID().toString() + fileType;

        // 构建日期路径，例如：OSS目标文件夹/2024/04/31/文件名
        String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

        // 文件上传的路径地址
        String uploadUrl = filePath + "/" + newFileName;

        // 获取文件输入流
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * 现在阿里云OSS默认图片上传ContentType是image/jpeg
         * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
         * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
         */
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentType("image/jpg");

        // 读取配置文件中的属性
        String endpoint = ossConfig.getEndpoint();
        String accessKeyId = ossConfig.getAccessKeyId();
        String accessKeySecret = ossConfig.getAccessKeySecret();
        String bucketName = ossConfig.getBucketName();

        // 创建 OSSClient
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 文件上传至阿里云OSS
        ossClient.putObject(bucketName, uploadUrl, inputStream, meta);

        // 获取文件上传后的图片返回地址
        returnImgUrl = "https://" + bucketName + "." + endpoint + "/" + uploadUrl;

        return returnImgUrl;
    }
      
    @Override
    public List<String> uploadPdf(MultipartFile file) throws IOException {
        List<String> returnImgUrl = new ArrayList<>();

        // 校验PDF格式
        boolean isLegal = false;
        if (StringUtils.endsWithIgnoreCase(file.getOriginalFilename(), IMAGE_TYPE_PDF)) {
            isLegal = true;
        }
        if (!isLegal) {
            // 如果PDF格式不合法，抛出异常
            throw new ServerException("PDF格式不正确");
        }

        // 保存上传的PDF文件到服务器
        String pdfFileName = file.getOriginalFilename();
        Path path = Paths.get("src/main/resources/static/pdfs/" + pdfFileName);
        Files.copy(file.getInputStream(), path);
        // 调用服务将PDF转换为图片
        String outputDir = pdfService.convertPdfToImages(path.toString());
        // 返回图片存储目录

        List<File> imageFiles = getImageFiles(outputDir);

        int count = 0;

        for (File imageFile : imageFiles) {
            // 获取文件原名称
            String originalFilename = imageFile.getName();

            // 获取文件类型，确保原文件名不为空
            assert originalFilename != null;
            String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));

            // 新文件名称
            String newFileName = count + fileType;

            // 构建日期路径，例如：OSS目标文件夹/2024/04/31/文件名
            String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

            // 文件上传的路径地址
            String uploadUrl = filePath + "/" + pdfFileName  + '/' + newFileName;

            // 获取文件输入流
            InputStream inputStream = null;
            try {
//                inputStream =  file.getInputStream();
                inputStream = new FileInputStream(imageFile); // 修改这里
            } catch (IOException e) {
                e.printStackTrace();
            }

            /*
             * 现在阿里云OSS默认图片上传ContentType是image/jpeg
             * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
             * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
             */
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/png");

            // 读取配置文件中的属性
            String endpoint = ossConfig.getEndpoint();
            String accessKeyId = ossConfig.getAccessKeyId();
            String accessKeySecret = ossConfig.getAccessKeySecret();
            String bucketName = ossConfig.getBucketName();

            // 创建 OSSClient
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

            // 文件上传至阿里云OSS
            ossClient.putObject(bucketName, uploadUrl, inputStream, meta);

            // 获取文件上传后的图片返回地址
            returnImgUrl.add("https://" + bucketName + "." + endpoint + "/" + uploadUrl);

            count++;

        }
        return returnImgUrl;

//        return "Images have been stored in: " + outputDir;

//        // 获取文件原名称
//        String originalFilename = file.getOriginalFilename();
//
//        // 获取文件类型，确保原文件名不为空
//        assert originalFilename != null;
//        String fileType = originalFilename.substring(originalFilename.lastIndexOf("."));
//
//        // 新文件名称
//        String newFileName = UUID.randomUUID().toString() + fileType;
//
//        // 构建日期路径，例如：OSS目标文件夹/2024/04/31/文件名
//        String filePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
//
//        // 文件上传的路径地址
//        String uploadUrl = filePath + "/" + newFileName;
//
//        // 获取文件输入流
//        InputStream inputStream = null;
//        try {
//            inputStream = file.getInputStream();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        /*
//         * 现在阿里云OSS默认图片上传ContentType是image/jpeg
//         * 也就是说，获取图片链接后，图片是下载链接，而并非在线浏览链接，
//         * 因此，这里在上传的时候要解决ContentType的问题，将其改为image/jpg
//         */
//        ObjectMetadata meta = new ObjectMetadata();
//        meta.setContentType("image/jpg");
//
//        // 读取配置文件中的属性
//        String endpoint = ossConfig.getEndpoint();
//        String accessKeyId = ossConfig.getAccessKeyId();
//        String accessKeySecret = ossConfig.getAccessKeySecret();
//        String bucketName = ossConfig.getBucketName();
//
//        // 创建 OSSClient
//        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//
//        // 文件上传至阿里云OSS
//        ossClient.putObject(bucketName, uploadUrl, inputStream, meta);
//
//        // 获取文件上传后的图片返回地址
//        returnImgUrl = "https://" + bucketName + "." + endpoint + "/" + uploadUrl;
//        return returnImgUrl;
    }

    public static List<File> getImageFiles(String directoryPath) {
        File directory = new File(directoryPath);
        List<File> imageFiles = new ArrayList<>();

        // 使用FilenameFilter来过滤图片文件
        FilenameFilter imageFilter = (dir, name) -> {
            String lowerName = name.toLowerCase();
            return lowerName.endsWith(".png");
        };

        // 获取目录下的所有文件
        File[] files = directory.listFiles(imageFilter);

        if (files != null) {
            for (File file : files) {
                imageFiles.add(file);
            }
        }

        return imageFiles;
    }

}
