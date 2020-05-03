package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Ifstable;
import com.swpu.asflow.entity.Interface;
import com.swpu.asflow.service.IDemandService;
import com.swpu.asflow.service.IInterfaceService;
import com.swpu.asflow.service.IModelService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
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
@RequestMapping("/interface")
public class InterfaceController {
@Autowired
    IInterfaceService iInterfaceService;
//@Autowired
//    IModelService iModelService;
//@Autowired
//    IDemandService iDemandService;
@RequestMapping("list")
    public Map list(@RequestParam("pid") Long pid,
                    @RequestParam("page") Integer page,
                    @RequestParam("limit") Integer limit){
    Page<Ifstable> pageArt=new Page<Ifstable>(page,limit);
    Page<Ifstable> page1 = iInterfaceService.list(pageArt,pid);
    return new HashMap<String, Object>() {{
        put("code", 0);
        put("msg", "SUCCESS");
        put("count", page1.getTotal());
        put("data", page1.getRecords());
    }};
}
    @RequestMapping("ifdo")
    public Msg ifdo(@RequestParam("mid")Long mid){
    int i =iInterfaceService.count(Wrappers.<Interface>lambdaQuery().eq(Interface::getMid,mid));
    return Msg.success().add("tip",i);
    }

    @RequestMapping("getint")
    public Map getint(@RequestParam("mid")Long mid,
                      @RequestParam("page") Integer page,
                      @RequestParam("limit") Integer limit){
        Page<Interface> artPage =iInterfaceService.page(new Page<>(page,limit),Wrappers.<Interface>lambdaQuery().eq(Interface::getMid,mid));
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", artPage.getTotal());
            put("data", artPage.getRecords());
        }};
    }

    @RequestMapping("addint")
    public Msg addint(@RequestParam("param[]") List param,@RequestParam("returnss") String  returnss, @RequestParam("uid")Long uid, @RequestParam("mid")Long mid,@RequestParam("disc")String disc,@RequestParam("title")String title)
    {   String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";
        boolean save=iInterfaceService.save(new Interface().setParameter(param.toString()).setMid(mid).setDisc(disc).setTime(LocalDateTime.now()).setUid(uid).setReturnss(returnss.toString().replaceAll(regEx," ")).setTitle(title));
        return save?Msg.success():Msg.fail();
    }

    @RequestMapping("del")
    public Msg del(@RequestParam("id")Long id){
    boolean del=iInterfaceService.remove(Wrappers.<Interface>lambdaQuery().eq(Interface::getId,id));
    return del?Msg.success():Msg.fail();
    }

    @RequestMapping("getallint")
    public Map getallint(@RequestParam("pid")Long pid,@RequestParam("page") Integer page,
                         @RequestParam("limit") Integer limit){
        Page<Interface> artPage=new Page<Interface>(page,limit);
        Page<Interface> page1 = iInterfaceService.getallint(artPage,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @RequestMapping("finint")
    public Msg finint(@RequestParam("id")Long id){
    boolean update=iInterfaceService.update(new Interface().setFlag(1),Wrappers.<Interface>lambdaQuery().eq(Interface::getId,id));
    return update?Msg.success():Msg.fail();
    }
    @RequestMapping("fininttest")
    public Msg fininttest(@RequestParam("id")Long id){
        boolean update=iInterfaceService.update(new Interface().setTestFlag(1),Wrappers.<Interface>lambdaQuery().eq(Interface::getId,id));
        return update?Msg.success():Msg.fail();
    }
}
