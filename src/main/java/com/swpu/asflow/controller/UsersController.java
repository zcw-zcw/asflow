package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Users;
import com.swpu.asflow.service.IUsersService;
import com.swpu.asflow.utils.Msg;
import org.apache.catalina.User;
import org.apache.catalina.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
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
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService iUsersService;

    /**
     * 登陆接口
     *
     * @param phone  账号
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public Msg login(@RequestParam("phone") String phone,
                     @RequestParam("password") String password) {
        // 条件构造器，用于sql语句where后面的条件拼装
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                //匹配账号
                .eq(Users::getPhone, phone)
                //匹配密码
                .eq(Users::getPwd, password);
        Users user = iUsersService.getOne(wrapper, false);
        return user == null ?
                Msg.fail().add("tip", "登陆失败，请重试。") :
                Msg.success().add("user", user);
    }


    /**
     * 注册接口
     *
     * @param phone  账号
     * @param password 密码
     * @param mail     类型 2为管理员 1为作者 0为专家
     * @param name     名字
     * @return
     */
    @PostMapping("/register")
    public Msg register(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        @RequestParam("name") String name,
                        @RequestParam("mail") String mail) {
        // 条件构造器
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                //匹配账号，如果账号已存在则注册失败
                .eq(Users::getPhone, phone);
        Users existUser = iUsersService.getOne(wrapper, false);
        if (existUser != null) {
            return Msg.fail().add("tip", "注册失败，账号已存在！");
        }
        Users user = new Users()
                .setPhone(phone)
                .setPwd(password)
                .setMail(mail)
                .setName(name)
                .setCreatTime(LocalDateTime.now());
        boolean isInserted = iUsersService.save(user);
        return !isInserted ?
                Msg.fail().add("tip", "注册失败，请重试！") :
                Msg.success().add("tip", "注册成功");
    }


@RequestMapping("/updataUser")
public Msg updataUser(@RequestParam("id") Long id,@RequestParam("mail")String mail,@RequestParam("pwd")String password){
   boolean updata=iUsersService.update(new Users().setPwd(password).setMail(mail), Wrappers.<Users>lambdaQuery().eq(Users::getId,id));
   return updata?Msg.success():Msg.fail();
}

    /**
     * 根据用户id删除用户
     *
     * @param uid 用户id
     * @return
     */
    @DeleteMapping("/delete/{uid}")
    public Msg deleteById(@PathVariable("uid") Integer uid) {
        boolean remove = iUsersService.removeById(uid);
        return remove ? Msg.success().add("tip", "删除成功。") : Msg.fail().add("tip", "删除失败，请重试。");
    }
}
