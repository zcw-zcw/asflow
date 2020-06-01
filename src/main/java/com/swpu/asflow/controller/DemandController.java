package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Demand;
import com.swpu.asflow.entity.DmdTable;
import com.swpu.asflow.entity.DptTable;
import com.swpu.asflow.service.IDemandService;
import com.swpu.asflow.utils.Msg;
import com.swpu.asflow.utils.Demandpdf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
@RequestMapping("/demand")
public class DemandController {
    @Autowired
    IDemandService iDemandService;

    /***
     * 初始化，返回该项目被删除的所有需求
     * @param pid
     * @return
     */
 @RequestMapping("/init")
    public Msg init(@RequestParam("pid")Long pid){
        List<Demand> list=iDemandService.list(Wrappers.<Demand>lambdaQuery().eq(Demand::getPid,pid).ne(Demand::getFlag,2));
        return Msg.success().add("demand",list);

    }

    /***
     * 返回所有确定的项目需求
     * @param pid
     * @return
     */
    @RequestMapping("/modelList")
    public Msg modelList(@RequestParam("pid")Long pid){
        List<Demand> list=iDemandService.list(Wrappers.<Demand>lambdaQuery().eq(Demand::getPid,pid).eq(Demand::getFlag,1));
        return Msg.success().add("demand",list);

    }

    /***
     * 返回需求
     * @param id
     * @return
     */
    @RequestMapping("/getOne")
    public Msg getOne(@RequestParam("id")Long id){
        Demand list=iDemandService.getOne(Wrappers.<Demand>lambdaQuery().eq(Demand::getId,id));
        return Msg.success().add("demand",list);

    }

    /***
     * 添加需求
     * @param uid
     * @param pid
     * @param title
     * @param content
     * @return
     */
 @RequestMapping("/addDemand")
    public Msg addDemand(@RequestParam("uid")Long uid,
                         @RequestParam("pid")Long pid,
                         @RequestParam("title")String title,
                         @RequestParam("content")String content){
     if(uid.equals(0)||title==null||title==""||content==""||content==null){
         return Msg.fail().add("tip","信息不完整");
     }
     boolean addDemand=iDemandService.save(new Demand().setContent(content).setFlag(0).setPid(pid).setTime(LocalDateTime.now()).setTitle(title).setUid(uid));
     return addDemand?Msg.success().add("tip","添加成功"): Msg.fail().add("tip","添加失败");
 }

    /***
     * 确定需求
     * @param id
     * @return
     */
 @RequestMapping("/sure")
    public Msg sure(@RequestParam("id[]")List id){
     boolean sure=iDemandService.update(new Demand().setFlag(1),Wrappers.<Demand>lambdaQuery().in(Demand::getId,id));
     return sure?Msg.success():Msg.fail();
 }

    /***
     * 待定需求
     * @param id
     * @return
     */
    @RequestMapping("/daiding")
    public Msg daiding(@RequestParam("id[]")List id){
        boolean sure=iDemandService.update(new Demand().setFlag(0),Wrappers.<Demand>lambdaQuery().in(Demand::getId,id));
        return sure?Msg.success():Msg.fail();
    }

    /***
     * 删除需求
     * @param id
     * @return
     */
    @RequestMapping("/del")
    public Msg delete(@RequestParam("id[]")List id){
        boolean sure=iDemandService.update(new Demand().setFlag(2),Wrappers.<Demand>lambdaQuery().in(Demand::getId,id));
        return sure?Msg.success():Msg.fail();
    }

    /***
     * 获取已删除的需求
     * @param pid
     * @return
     */
    @RequestMapping("/getDelete")
    public Msg getDelete(@RequestParam("pid")Long pid){
        List<Demand> list=iDemandService.list(Wrappers.<Demand>lambdaQuery().eq(Demand::getPid,pid).eq(Demand::getFlag,2));
        return Msg.success().add("demand",list);

    }

    /***
     * 恢复删除的需求
     * @param id
     * @return
     */
    @RequestMapping("/resume")
    public Msg resume(@RequestParam("id")Long id){
        boolean sure=iDemandService.update(new Demand().setFlag(0),Wrappers.<Demand>lambdaQuery().eq(Demand::getId,id));
        return sure?Msg.success():Msg.fail();
    }

    @RequestMapping("getDemand")
    public Map getDemand(@RequestParam("list")List list,
                        @RequestParam("page") Integer page,
                         @RequestParam("limit") Integer limit){
        Page<DmdTable> pageArt=new Page<DmdTable>(page,limit);
        Page<DptTable> page1 = iDemandService.getDemand(pageArt,list);

        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @RequestMapping("getTestDemand")
    public Map getTestDemand(@RequestParam("pid")int pid,
                         @RequestParam("page") Integer page,
                         @RequestParam("limit") Integer limit){
        Page<Demand> pageArt=new Page<Demand>(page,limit);
        Page<Demand> page1 = iDemandService.page(pageArt,new LambdaQueryWrapper<Demand>().eq(Demand::getPid,pid).orderByAsc(Demand::getTestFlag));

        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @RequestMapping("fininttest")
    public Msg fininttest(@RequestParam("id")long id){
        boolean update=iDemandService.update(new Demand().setTestFlag(1),Wrappers.<Demand>lambdaQuery().eq(Demand::getId,id));
        return update?Msg.success().add("tip","完成测试"):Msg.fail().add("tip","完成失败，请重试");
    }

}
