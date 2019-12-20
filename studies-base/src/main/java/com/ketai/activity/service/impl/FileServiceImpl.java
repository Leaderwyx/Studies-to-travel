package com.ketai.activity.service.impl;

import com.ketai.activity.pojo.File;
import com.ketai.activity.mapper.FileMapper;
import com.ketai.activity.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动照片表 服务实现类
 * </p>
 *
 * @author ChildeLiao
 * @since 2019-12-20
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
