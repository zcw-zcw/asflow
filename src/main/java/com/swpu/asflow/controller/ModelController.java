package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.swpu.asflow.entity.*;
import com.swpu.asflow.service.IDemandService;
import com.swpu.asflow.service.IModelService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/model")
public class ModelController {
    @Autowired
    IModelService iModelService;
    @RequestMapping("/init")
    public Msg init(@RequestParam("did")Long did){
        List<Model> list=iModelService.list(Wrappers.<Model>lambdaQuery().eq(Model::getDid,did).ne(Model::getFlag,2));
        return Msg.success().add("model",list);

    }
    @RequestMapping("/modelList2")
    public Msg modelList2(@RequestParam("did")Long did){
        List<Model> list=iModelService.list(Wrappers.<Model>lambdaQuery().eq(Model::getDid,did).eq(Model::getFlag,1));
        return Msg.success().add("model",list);

    }
    @RequestMapping("/getOne")
    public Msg getOne(@RequestParam("id")Long id){
        Model list=iModelService.getOne(Wrappers.<Model>lambdaQuery().eq(Model::getId,id));
        return Msg.success().add("model",list);

    }
    @RequestMapping("/addModel")
    public Msg addModel(@RequestParam("uid")Long uid,
                         @RequestParam("did")Long did,
                         @RequestParam("title")String title,
                         @RequestParam("content")String content){
        if(uid.equals(0)||title==null||title==""||content==""||content==null){
            return Msg.fail().add("tip","信息不完整");
        }
        boolean addModel=iModelService.save(new Model().setContent(content).setFlag(0).setDid(did).setTime(LocalDateTime.now()).setTitle(title).setUid(uid));
        return addModel?Msg.success().add("tip","添加成功"): Msg.fail().add("tip","添加失败");
    }

    @RequestMapping("/sure")
    public Msg sure(@RequestParam("id[]")List id){
        boolean sure=iModelService.update(new Model().setFlag(1),Wrappers.<Model>lambdaQuery().in(Model::getId,id));
        return sure?Msg.success():Msg.fail();
    }
    @RequestMapping("/daiding")
    public Msg daiding(@RequestParam("id[]")List id){
        boolean sure=iModelService.update(new Model().setFlag(0),Wrappers.<Model>lambdaQuery().in(Model::getId,id));
        return sure?Msg.success():Msg.fail();
    }

    @RequestMapping("/del")
    public Msg delete(@RequestParam("id[]")List id){
        boolean sure=iModelService.update(new Model().setFlag(2),Wrappers.<Model>lambdaQuery().in(Model::getId,id));
        return sure?Msg.success():Msg.fail();
    }
    @RequestMapping("/getDelete")
    public Msg getDelete(@RequestParam("did")Long did){
        List<Model> list=iModelService.list(Wrappers.<Model>lambdaQuery().eq(Model::getDid,did).eq(Model::getFlag,2));
        return Msg.success().add("model",list);

    }

    @RequestMapping("/resume")
    public Msg resume(@RequestParam("id")Long id){
        boolean sure=iModelService.update(new Model().setFlag(0),Wrappers.<Model>lambdaQuery().eq(Model::getId,id));
        return sure?Msg.success():Msg.fail();
    }
    @RequestMapping("getModel")
    public Map getModel(@RequestParam("list")List list,
                         @RequestParam("page") Integer page,
                         @RequestParam("limit") Integer limit){
        Page<ModTable> pageArt=new Page<ModTable>(page,limit);
        Page<DptTable> page1 = iModelService.getModel(pageArt,list);

        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    /***
     * 是否处理了需求
     */
    @RequestMapping("ifdo")
    public Msg ifdo(@RequestParam("did")Long did){
        int i=iModelService.count(Wrappers.<Model>lambdaQuery().eq(Model::getDid,did).eq(Model::getFlag,1));
        return Msg.success().add("tip",i);
    }
}
