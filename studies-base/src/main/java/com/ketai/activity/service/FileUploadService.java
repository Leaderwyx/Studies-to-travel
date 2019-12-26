package com.ketai.activity.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 文件上传 服务类
 * </p>
 * @author ChildeXiao
 * @version 创建时间：2019/12/23 10:37
 */
public interface FileUploadService {

    /**
     * 文件上传至阿里云
     * @param file
     * @return
     */
    String upload(MultipartFile file);
}
