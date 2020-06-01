package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Job;
import com.swpu.asflow.entity.Jobtable;
import com.swpu.asflow.service.IJobService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
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
@RequestMapping("/job")
public class JobController {
    @Autowired
    IJobService iJobService;
    @RequestMapping("addjob")
    public Msg  addjob(@RequestParam("fromid")Long fromid, @RequestParam("getid")Long getid, @RequestParam("disc")String  disc, @RequestParam("creatTime") String date, @RequestParam("iid")Long iid,@RequestParam("pid")Long pid){
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[['T'hh][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        final LocalDateTime sendTime = LocalDateTime.parse(date, formatter);
        Job job=iJobService.getOne(Wrappers.<Job>lambdaQuery().eq(Job::getIid,iid).eq(Job::getType,1));
        if (job==null){
        boolean save=iJobService.save(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFormid(fromid).setGetid(getid).setIid(iid).setPid(pid).setFlag(0).setType(1));
        return save?Msg.success().add("tip","添加成功"):Msg.fail().add("tip","添加失败！");}
        else if(job!=null){
            boolean save=iJobService.update(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFlag(0).setFormid(fromid).setGetid(getid).setIid(iid).setPid(pid).setType(1),Wrappers.<Job>lambdaUpdate().eq(Job::getIid,iid));
            return save?Msg.success().add("tip","添加成功"):Msg.fail().add("tip","添加失败！");}
else {
    return Msg.fail();
        }
        }
    @RequestMapping("addtestjob")
    public Msg  addtestjob(@RequestParam("fromid")Long fromid, @RequestParam("getid")Long getid, @RequestParam("disc")String  disc, @RequestParam("creatTime") String date, @RequestParam("id")Long id,@RequestParam("pid")Long pid,@RequestParam("type")long type){
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[['T'hh][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        final LocalDateTime sendTime = LocalDateTime.parse(date, formatter);
        if(type==2) {
            Job job = iJobService.getOne(Wrappers.<Job>lambdaQuery().eq(Job::getIid, id).eq(Job::getType, 2));
            if (job == null) {
                boolean save = iJobService.save(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFormid(fromid).setGetid(getid).setIid(id).setPid(pid).setFlag(0).setType(2));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            } else {
                boolean save = iJobService.update(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFlag(0).setFormid(fromid).setGetid(getid).setIid(id).setPid(pid).setType(2), Wrappers.<Job>lambdaUpdate().eq(Job::getIid, id));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            }
        }else if(type==3){
            Job job = iJobService.getOne(Wrappers.<Job>lambdaQuery().eq(Job::getDid, id).eq(Job::getType, 3));
            if (job == null) {
                boolean save = iJobService.save(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFormid(fromid).setGetid(getid).setDid(id).setPid(pid).setFlag(0).setType(3));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            } else {
                boolean save = iJobService.update(new Job().setCreatTime(LocalDateTime.now()).setDisc(disc).setFinalTime(sendTime).setFlag(0).setFormid(fromid).setGetid(getid).setDid(id).setPid(pid).setType(3), Wrappers.<Job>lambdaUpdate().eq(Job::getDid, id));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            }
        }else {
            return Msg.fail().add("tip","信息错误");
        }
    }
    @RequestMapping("addtestjobmanager")
    public Msg  addtestjobmanager(@RequestParam("getid")Long getid, @RequestParam("coderid")Long coderid,  @RequestParam("date") String date, @RequestParam("id")Long id,@RequestParam("pid")Long pid,@RequestParam("type")long type){
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[['T'hh][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        final LocalDateTime sendTime = LocalDateTime.parse(date, formatter);
        if(type==2) {
            Job job = iJobService.getOne(Wrappers.<Job>lambdaQuery().eq(Job::getIid, id).eq(Job::getType, 2));
            if (job == null) {
                boolean save = iJobService.save(new Job().setCreatTime(LocalDateTime.now()).setFinalTimeManager(sendTime).setCoderid(coderid).setIid(id).setPid(pid).setFlag(0).setType(2));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            } else {
                boolean save = iJobService.update(new Job().setCreatTime(LocalDateTime.now()).setFinalTimeManager(sendTime).setFlag(0).setCoderid(coderid).setIid(id).setPid(pid).setType(2), Wrappers.<Job>lambdaUpdate().eq(Job::getIid, id).eq(Job::getGetid,getid));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            }
        }else if(type==3){
            Job job = iJobService.getOne(Wrappers.<Job>lambdaQuery().eq(Job::getDid, id).eq(Job::getType, 3));
            if (job == null) {
                boolean save = iJobService.save(new Job().setCreatTime(LocalDateTime.now()).setFinalTimeManager(sendTime).setCoderid(coderid).setDid(id).setPid(pid).setFlag(0).setType(3));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            } else {
                boolean save = iJobService.update(new Job().setCreatTime(LocalDateTime.now()).setFinalTimeManager(sendTime).setFlag(0).setCoderid(coderid).setDid(id).setPid(pid).setType(3), Wrappers.<Job>lambdaUpdate().eq(Job::getDid, id).eq(Job::getGetid,getid));
                return save ? Msg.success().add("tip", "添加成功") : Msg.fail().add("tip", "添加失败！");
            }
        }else {
            return Msg.fail().add("tip","信息错误");
        }
    }
        @GetMapping("getjob")
    public Map getJob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                      @RequestParam("limit") Integer limit){
            Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);
            Page<Jobtable> page1 = iJobService.getjob(pageArt,uid,pid);
            return new HashMap<String, Object>() {{
                put("code", 0);
                put("msg", "SUCCESS");
                put("count", page1.getTotal());
                put("data", page1.getRecords());
            }};
        }
    @GetMapping("getmanajob")
    public Map getmanajob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                      @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getmanajob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @GetMapping("getcoderjob")
    public Map getcoderjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                          @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getcoderjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("getmanagertocoderjob")
    public Map getmanagertocoderjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                           @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getmanagertocoderjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("getmanagertocodertestjob")
    public Map getmanagertocodertestjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                                    @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getmanagertocodertestjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("getmanagertocoderdemandtestjob")
    public Map getmanagertocoderdemandtestjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                                        @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getmanagertocoderdemandtestjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("gettestjob")
    public Map gettestjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                      @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);
        Page<Jobtable> page1 = iJobService.gettestjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("gettestmanajob")
    public Map gettestmanajob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                          @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.gettestmanajob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @GetMapping("gettestcoderjob")
    public Map gettestcoderjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                           @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.gettestcoderjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @GetMapping("getdemandtestjob")
    public Map getdemandtestjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                          @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);
        Page<Jobtable> page1 = iJobService.getdemandtestjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @GetMapping("getdemandtestmanajob")
    public Map getdemandtestmanajob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                              @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getdemandtestmanajob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    @GetMapping("getdemandtestcoderjob")
    public Map getdemandtestcoderjob(@RequestParam("uid")Long uid,@RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                               @RequestParam("limit") Integer limit){
        Page<Jobtable> pageArt=new Page<Jobtable>(page,limit);

        Page<Jobtable> page1 = iJobService.getdemandtestcoderjob(pageArt,uid,pid);
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }
    @RequestMapping("setjob")
    public  Msg setJob(@RequestParam("id")long id,@RequestParam("cpt")int cpt ){
        boolean update=iJobService.update(Wrappers.<Job>lambdaQuery().eq(Job::getId,id).eq(Job::getFlag,1).eq(Job::getCompletion,cpt));
        return update?Msg.success():Msg.fail();
        }

    @RequestMapping("subjob")
    public  Msg subjob(@RequestParam("uid")long uid,@RequestParam("pid")long pid,@RequestParam("iid")long iid,@RequestParam("cpt")int cpt, @RequestParam("sub")int sub_flag){
        int flag=1;
        if (cpt==4){
             flag=2;
        }
        boolean update=iJobService.update(new Job().setSubTime(LocalDateTime.now()).setFlag(flag).setCompletion(cpt).setSubFlag(sub_flag).setSubid(uid),Wrappers.<Job>lambdaQuery().eq(Job::getIid,iid).eq(Job::getPid,pid));
        return update?Msg.success():Msg.fail().add("tip","提交失败");
    }

    @RequestMapping("refjob")
    public Msg refjob(@RequestParam("id")Long id){
        boolean update=iJobService.update(new Job().setFlag(3),Wrappers.<Job>lambdaUpdate().eq(Job::getId,id));
        return update?Msg.success():Msg.fail();
    }
    @RequestMapping("reftestjob")
    public Msg reftestjob(@RequestParam("id")Long id){
        boolean update=iJobService.update(new Job().setFlag(3),Wrappers.<Job>lambdaUpdate().eq(Job::getId,id));
        return update?Msg.success():Msg.fail();
    }
    @RequestMapping("refdemandtestjob")
    public Msg refdemandtestjob(@RequestParam("id")Long id){
        boolean update=iJobService.update(new Job().setFlag(3),Wrappers.<Job>lambdaUpdate().eq(Job::getId,id));
        return update?Msg.success():Msg.fail();
    }

    @RequestMapping("addcoderjob")
    public Msg addcoderjob(@RequestParam("pid")Long pid,@RequestParam("iid")Long iid,@RequestParam("coderid")Long coderid,@RequestParam("date")String date){
        final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd[['T'hh][:mm][:ss]]")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 23)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .parseDefaulting(ChronoField.MILLI_OF_SECOND, 0)
                .toFormatter();
        final LocalDateTime sendTime = LocalDateTime.parse(date, formatter);
        boolean update=iJobService.update(new Job().setCoderid(coderid).setFinalTimeManager(sendTime),Wrappers.<Job>lambdaQuery().eq(Job::getPid,pid).eq(Job::getIid,iid));
        return update?Msg.success():Msg.fail();
    }
}
