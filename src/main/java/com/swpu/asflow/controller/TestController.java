package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.swpu.asflow.entity.Job;
import com.swpu.asflow.entity.Test;
import com.swpu.asflow.service.IJobService;
import com.swpu.asflow.service.ITestService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    ITestService iTestService;
    @Autowired
    IJobService iJobService;

    @PostMapping("upload")
    public Msg upload(@RequestParam("upfile[]") MultipartFile files[], @RequestParam("completion") Integer completion, @RequestParam("uid") long uid,
                      @RequestParam("pid") long pid, @RequestParam("iid") long iid, @RequestParam("dis") String dis,@RequestParam("type")int type) {
        if (files.length == 0) {
            return Msg.fail().add("tip", "未选择文件，请重试。");
        }
        try {
            for (MultipartFile file : files) {
                InputStream inputStream = file.getInputStream();
                // 将上传的文件存入 "工程目录/src/main/resources/docs/" 目录下
                String path = System.getProperty("user.dir") + "/src/main/resources/photo/" + file.getOriginalFilename()
                        .replaceAll(" ", "");
                System.out.println(file.getOriginalFilename());
                OutputStream os = new FileOutputStream(path);
//            file.transferTo(new File(path));
//            FileUtils.copyInputStreamToFile(file.getInputStream(), path);
//         1KB 的缓冲区
                byte[] bs = new byte[1024];
                int len;
                while ((len = inputStream.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                int flag=1;
                if (completion==4){
                    flag=2;
                }
                if (type==2) {

                    boolean save = iTestService.save(new Test().setDisc(dis).setIid(iid).setTime(LocalDateTime.now()).setUid(uid).setUrl("/photo/" + file.getOriginalFilename()).setType(type));
                    boolean update=iJobService.update(new Job().setSubTime(LocalDateTime.now()).setFlag(flag).setCompletion(completion).setSubid(uid),Wrappers.<Job>lambdaQuery().eq(Job::getIid,iid).eq(Job::getPid,pid));
                if (!save||!update) {
                    return Msg.fail().add("tip", "保存失败");
                }}if (type==3){
                    boolean save = iTestService.save(new Test().setDisc(dis).setDid(iid).setTime(LocalDateTime.now()).setUid(uid).setUrl("/photo/" + file.getOriginalFilename()).setType(type));
                    boolean update=iJobService.update(new Job().setSubTime(LocalDateTime.now()).setFlag(flag).setCompletion(completion).setSubid(uid),Wrappers.<Job>lambdaQuery().eq(Job::getDid,iid).eq(Job::getPid,pid));
                    if (!save||!update) {
                        return Msg.fail().add("tip", "保存失败");
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.toString());
            return Msg.fail().add("tip", "发布失败，请重试。");
        }


        return Msg.success().add("tip","提交成功");

    }

    @GetMapping("getphoto")
    public Msg getphoto(@RequestParam("iid") long iid,@RequestParam("did") long did, @RequestParam("type") long type) {
        if (type == 2) {
            return Msg.success().add("photo", iTestService.list(Wrappers.<Test>lambdaQuery().eq(Test::getIid, iid)));
        } else if (type == 3) {
            return Msg.success().add("photo", iTestService.list(Wrappers.<Test>lambdaQuery().eq(Test::getDid, did)));
        } else {
            return Msg.fail().add("tip","类型不正确");
        }
    }
}