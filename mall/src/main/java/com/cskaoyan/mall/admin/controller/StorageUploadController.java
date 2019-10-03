package com.cskaoyan.mall.admin.controller;

import com.cskaoyan.mall.admin.bean.CskaoyanMallStorage;
import com.cskaoyan.mall.admin.service.SystemManageService;
import com.cskaoyan.mall.admin.util.FileNameUtils;
import com.cskaoyan.mall.admin.util.FileUtils;
import com.cskaoyan.mall.admin.vo.BaseResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("admin/storage")
public class StorageUploadController {
    @Autowired
    SystemManageService systemManageService;

    private final ResourceLoader resourceLoader;

    @Autowired
    public StorageUploadController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${upload.path}")
    private String path;

    @RequestMapping(value = "create")
    public BaseResponseVo create(@RequestParam("file")MultipartFile file){
        String filename = file.getOriginalFilename();
        String newname = FileNameUtils.getFileName(filename);
        boolean upload = FileUtils.upload(file, path, newname);
        String type = "image/" + FileNameUtils.getSuffix(filename).replace(".","");
        int size = (int)file.getSize();
        String url =  "http://localhost/image/" + newname;
        if (upload){
            CskaoyanMallStorage storage = systemManageService.create(newname, filename, type, size, url);
            BaseResponseVo ok = BaseResponseVo.ok(storage);
            return ok;
        }
        return null;
    }

    @RequestMapping(value = "delete")
    public BaseResponseVo delete(@RequestBody CskaoyanMallStorage storage){
        boolean delete = systemManageService.deleteStorage(storage.getId());
        if (delete){
            BaseResponseVo ok = BaseResponseVo.ok();
            return ok;
        }
        return null;
    }
}
