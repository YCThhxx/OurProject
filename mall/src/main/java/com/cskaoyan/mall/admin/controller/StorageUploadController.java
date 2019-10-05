package com.cskaoyan.mall.admin.controller;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.config.MallOssConfig;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.util.FileNameUtils;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.UUID;


@RestController
@RequestMapping("admin/storage")
public class StorageUploadController {
    @Autowired
    MallOssConfig mallOssConfig;
    @Autowired
    SystemManageService systemManageService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public StorageUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${upload.path}")
    private String path;
    
//    @RequestMapping("create")
//    public BaseResponseVo upload(@RequestParam("file") MultipartFile file) throws IOException {
//        File file1 = null;
//        String originalFilename = file.getOriginalFilename();
//        String originalFilename1 = "target/classes/static/image/" + originalFilename;
//        file1 = new File(ResourceUtils.getURL(originalFilename1).getPath());
//        file.transferTo(file1);
//        String type = "image/" + FileNameUtils.getSuffix(originalFilename1).replace(".","");
//        int size = (int)file.getSize();
//        InetAddress localHost = Inet4Address.getLocalHost();
//        String hostAddress = localHost.getHostAddress();
//        String url =  "http://"+hostAddress+"/image/" + originalFilename;
//        CskaoyanMallStorage storage = systemManageService.create(originalFilename, originalFilename, type, size, url);
//        BaseResponseVo ok = BaseResponseVo.ok(storage);
//        return ok;
//    }

    @RequestMapping(value = "delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallStorage storage){
        boolean delete = systemManageService.deleteStorage(storage.getId());
        if (delete){
            BaseResponseVo ok = BaseResponseVo.ok();
            return ok;
        }
        return null;
    }
    @RequestMapping("create")
    public BaseResponseVo upload(@RequestParam("file") MultipartFile file) throws IOException {
        //下面是文件上传
        InputStream inputStream = file.getInputStream();
        String bucket = mallOssConfig.getBucket();
        String endPoint = mallOssConfig.getEndPoint();
        String accessKeyId = mallOssConfig.getAccessKeyId();
        String accessSecret = mallOssConfig.getAccessSecret();
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessSecret);
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        String key = uuid + file.getOriginalFilename();
        ossClient.putObject(new PutObjectRequest(bucket,key, inputStream));

        //下面是获得参数
        File file1 = null;
        String originalFilename = file.getOriginalFilename();
        String originalFilename1 = "target/classes/static/image/" + originalFilename;
        file1 = new File(ResourceUtils.getURL(originalFilename1).getPath());
        file.transferTo(file1);
        String type = "image/" + FileNameUtils.getSuffix(originalFilename1).replace(".","");
        int size = (int)file.getSize();
        String url = "https://cskaoyan.oss-cn-beijing.aliyuncs.com/" + key;
        System.out.println(url);
        CskaoyanMallStorage storage = systemManageService.create(key, file.getOriginalFilename(), type, size, url);
      BaseResponseVo ok = BaseResponseVo.ok(storage);
       return ok;
        
       //下面是国庆写的
        //        File file1 = null;
//        String originalFilename = file.getOriginalFilename();
//        String originalFilename1 = "target/classes/static/image/" + originalFilename;
//        file1 = new File(ResourceUtils.getURL(originalFilename1).getPath());
//        file.transferTo(file1);
//        String type = "image/" + FileNameUtils.getSuffix(originalFilename1).replace(".","");
//        int size = (int)file.getSize();
//        InetAddress localHost = Inet4Address.getLocalHost();
//        String hostAddress = localHost.getHostAddress();
//        String url =  "http://"+hostAddress+"/image/" + originalFilename;
//        CskaoyanMallStorage storage = systemManageService.create(originalFilename, originalFilename, type, size, url);
//        BaseResponseVo ok = BaseResponseVo.ok(storage);
//        return ok;
    }
}
