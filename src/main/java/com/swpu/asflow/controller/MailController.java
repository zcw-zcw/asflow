package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Mail;
import com.swpu.asflow.entity.MailTable;
import com.swpu.asflow.entity.Users;
import com.swpu.asflow.service.IMailService;
import com.swpu.asflow.service.IUsersService;
import com.swpu.asflow.utils.Msg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    IMailService iMailService;
    @Autowired
    IUsersService iUsersService;
    /***
     * 初始化邮件信息
     * @param id
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("init")
    public Map init(@RequestParam("id")Long id,
                    @RequestParam("page") Integer page,
                    @RequestParam("limit") Integer limit){
    Page<MailTable> pageArt=new Page<MailTable>(page,limit);
    Page<MailTable> page1 = iMailService.getMail(pageArt,id);

    return new HashMap<String, Object>() {{
        put("code", 0);
        put("msg", "SUCCESS");
        put("count", page1.getTotal());
        put("data", page1.getRecords());

}};}

    /***
     * 邮件已读操作
     * @param id
     * @return
     */
    @RequestMapping("/read")
public Msg read(@RequestParam("id")Long id){
    boolean read=iMailService.update(new Mail().setFlag(1), Wrappers.<Mail>lambdaQuery().eq(Mail::getId,id));
    return read?Msg.success().add("tip","成功"):Msg.fail().add("tip","失败");
}

    /***
     * 删除邮件
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public Msg del(@RequestParam("id")Long id){
        boolean read=iMailService.remove( Wrappers.<Mail>lambdaQuery().eq(Mail::getId,id));
        return read?Msg.success().add("tip","成功"):Msg.fail().add("tip","失败");
    }

    @RequestMapping("getnum")
    public Msg getNum(@RequestParam("id")Long id){
        int i=iMailService.count(Wrappers.<Mail>lambdaQuery().eq(Mail::getGetid,id).eq(Mail::getFlag,0));
        return Msg.success().add("tip",i);
    }

    @RequestMapping("send")
    public Msg send(@RequestParam("sendid")Long sendid,@RequestParam("title")String title,@RequestParam("cont")String cont,@RequestParam("phone")String phone){
        Users users=iUsersService.getOne(Wrappers.<Users>lambdaQuery().eq(Users::getPhone,phone));
        if(users==null){
            return Msg.fail().add("tip","找不到该用户");
        }
        boolean save=iMailService.save(new Mail().setCont(cont).setGetid(users.getId()).setSentid(sendid).setTitle(title).setTime(LocalDateTime.now()));
        return save?Msg.success().add("tip","发送成功"):Msg.fail().add("tip","发送失败");
    }
}
