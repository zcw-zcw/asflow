package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.swpu.asflow.entity.Sqltbl;
import com.swpu.asflow.service.ISqlService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@RestController
@RequestMapping("/sql")
public class SqlController {
    @Autowired
    ISqlService iSqlService;
    @PostMapping("upload")
    public Msg upload(@RequestParam("upfile") MultipartFile files, @RequestParam("uid") long uid,
                      @RequestParam("pid") long pid) {
        Sqltbl sqltbl=iSqlService.getOne(Wrappers.<Sqltbl>lambdaQuery());
        if (files == null) {
            return Msg.fail().add("tip", "未选择文件，请重试。");
        }
        try {

                if(!files.getOriginalFilename().endsWith(".sql")){
                    return Msg.fail().add("tip","文件格式错误");
                }
                InputStream inputStream = files.getInputStream();
                // 将上传的文件存入 "工程目录/src/main/resources/docs/" 目录下
                String path = System.getProperty("user.dir") + "/src/main/resources/sql/" + files.getOriginalFilename()
                        .replaceAll(" ", "");
                OutputStream os = new FileOutputStream(path);
//            file.transferTo(new File(path));
//            FileUtils.copyInputStreamToFile(file.getInputStream(), path);
//         1KB 的缓冲区
                byte[] bs = new byte[1024];
                int len;
                while ((len = inputStream.read(bs)) != -1) {
                    os.write(bs, 0, len);
                }
                if (sqltbl==null){
                boolean save = iSqlService.save(new Sqltbl().setPid(pid).setTime(LocalDateTime.now()).setUid(uid).setUrl("/sql/" + files.getOriginalFilename()));
                if (!save) {
                    return Msg.fail().add("tip", "保存失败");
                }}else {
                    boolean save = iSqlService.update(new Sqltbl().setPid(pid).setTime(LocalDateTime.now()).setUid(uid).setUrl("/sql/" + files.getOriginalFilename()),Wrappers.<Sqltbl>lambdaUpdate().eq(Sqltbl::getPid,pid));
                    if (!save) {
                        return Msg.fail().add("tip", "保存失败");
                    }
                }

        } catch (IOException e) {
            System.out.println(e.toString());
            return Msg.fail().add("tip", "发布失败，请重试。");
        }

        return Msg.success().add("tip", "保存成功");
    }

    @GetMapping("getsql")
    public Msg getsql(@RequestParam("pid") long pid) {

            return Msg.success().add("sql", iSqlService.getOne(Wrappers.<Sqltbl>lambdaQuery().eq(Sqltbl::getPid, pid)));

    }
}