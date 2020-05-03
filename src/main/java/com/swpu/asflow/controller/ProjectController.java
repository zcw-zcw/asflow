package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.*;
import com.swpu.asflow.mapper.DepartmentMapper;
import com.swpu.asflow.service.*;
import com.swpu.asflow.utils.Demandpdf;
import com.swpu.asflow.utils.Interfacepdf;
import com.swpu.asflow.utils.Modelpdf;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    IProjectService iProjectService;
    @Autowired
    IDepartmentService  iDepartmentService;
    @Autowired
    IDemandService iDemandService;
    @Autowired
    IModelService iModelService;
    @Autowired
    IInterfaceService iInterfaceService;
    @RequestMapping("/get")
    public Map getProjectbyId(@RequestParam("uid") Integer uid,
                           @RequestParam("page") Integer page,
                           @RequestParam("limit") Integer limit) {
        List<Department> arrayList=iDepartmentService.list(Wrappers.<Department>lambdaQuery().eq(Department::getUid,uid));
        List<Long> list=new ArrayList<>();
        for ( Department arrar : arrayList){
            list.add(arrar.getPid());
        }
        Page<Project> artPage = iProjectService.page(new Page<>(page, limit), new LambdaQueryWrapper<Project>().in(Project::getId, list).orderByDesc(Project::getCreatTime));
        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", artPage.getTotal());
            put("data", artPage.getRecords());
        }};
    }
    @PostMapping("/set")
    public  Msg setProject(@RequestParam("name") String name,
                           @RequestParam("desc") String desc,
                           @RequestParam("uid") String uid){
        if(name==""||name==null||desc==""||desc==null){
            return Msg.fail().add("tip","信息不完整，请重试！");
        }
          boolean saveP=  iProjectService.save(new Project().setCreatTime(LocalDateTime.now()).setDsr(desc).setName(name).setUid(Long.parseLong(uid)));
        boolean saveD=iDepartmentService.save(new Department().setGroupid(0).setPid(iProjectService.getOne(Wrappers.<Project>lambdaQuery().eq(Project::getUid,Long.parseLong(uid)).eq(Project::getName,name)).getId()).setRole(0).setUid(Long.parseLong(uid)));
        return saveP&&saveD ? Msg.success().add("tip", "添加完成。") : Msg.fail().add("tip", "添加失败。");
    }

    @GetMapping("join")
    public Msg joinProject(@RequestParam("id") Long id,
                           @RequestParam("uid") Long uid){
        Department join=iDepartmentService.getOne(Wrappers.<Department>lambdaQuery().eq(Department::getUid,uid).eq(Department::getPid,id));
        if (join==null){
            return Msg.fail().add("tip","找不到该项目，请刷新后重试!");
        }else {
            return Msg.success().add("code",join.getRole()).add("pid",join.getPid());
        }
    }

    @GetMapping("out")
    public Msg outProject(@RequestParam("id") Long id,
                           @RequestParam("uid") Long uid){
        Department out=iDepartmentService.getOne(Wrappers.<Department>lambdaQuery().eq(Department::getUid,uid).eq(Department::getPid,id));
        if (out==null){
            return Msg.fail().add("tip","找不到该项目，请刷新后重试!");
        }else if(out.getRole().equals(0)){
            return Msg.fail().add("tip","管理员不能退出项目！");
        }else {
            boolean delete=iDepartmentService.remove(Wrappers.<Department>lambdaQuery().eq(Department::getPid,id).eq(Department::getUid,uid));
            return delete ? Msg.success().add("tip", "退出成功。") : Msg.fail().add("tip", "推出失败，请重试！。");
        }
    }

    @GetMapping("getpro")
    public Msg getProject(@RequestParam("pid") Long pid,@RequestParam("uid")Long uid){
        Project project=iProjectService.getById(pid);
        Department department=iDepartmentService.getOne(Wrappers.<Department>lambdaQuery().eq(Department::getPid,pid).eq(Department::getUid,uid));
        if (project==null){
            return  Msg.fail().add("tip","找不到该项目");
        }else if(department==null){
            return Msg.fail().add("tip","您不属于该项目组！");
        }
        else {
            return Msg.success().add("project",project);
        }
    }

    @PostMapping("next")
    public Msg next(@RequestParam("pid")Long pid){
        boolean next=iProjectService.update(new Project().setStage(2),Wrappers.<Project>lambdaQuery().eq(Project::getId,pid));
        Demandpdf demandpdf =new Demandpdf();
        String filename =  System.getProperty("user.dir") + "/src/main/resources/pdf/"+pid+"demand.pdf";
        List<Demand> list=iDemandService.list(Wrappers.<Demand>lambdaQuery().eq(Demand::getPid,11).eq(Demand::getFlag,1));
        try {
            demandpdf.createPDF(filename,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return next?Msg.success():Msg.fail();
    }
    @GetMapping("check")
    public Msg check(@RequestParam("pid")Long pid){
       Project project=iProjectService.getById(pid);

        return Msg.success().add("project",project);
    }
    @PostMapping("nextint")
    public Msg nextint(@RequestParam("pid")Long pid){
        boolean next=iProjectService.update(new Project().setStage(3),Wrappers.<Project>lambdaQuery().eq(Project::getId,pid));
        List<Demand> list=iDemandService.list(Wrappers.<Demand>lambdaQuery().eq(Demand::getPid,11).eq(Demand::getFlag,1));
        List<Long> longs=new ArrayList<>();
        for(Demand demand:list){
            longs.add(demand.getId());
        }
        Modelpdf demandpdf =new Modelpdf();
        String filename =  System.getProperty("user.dir") + "/src/main/resources/pdf/"+pid+"model.pdf";
        List<Model> list2=iModelService.list(Wrappers.<Model>lambdaQuery().in(Model::getDid,longs).eq(Model::getFlag,1));
        try {
            demandpdf.createPDF(filename,list2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return next?Msg.success():Msg.fail();
    }
    @PostMapping("nextcode")
    public Msg nextcode(@RequestParam("pid")Long pid){
        boolean next=iProjectService.update(new Project().setStage(4),Wrappers.<Project>lambdaQuery().eq(Project::getId,pid));
        Interfacepdf interfacepdf =new Interfacepdf();
        String filename =  System.getProperty("user.dir") + "/src/main/resources/pdf/"+pid+"interface.pdf";
        List<Interface> list=iInterfaceService.getint(pid);
        try {
            interfacepdf.createPDF(filename,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return next?Msg.success():Msg.fail();
    }
    @PostMapping("nexttest")
    public Msg nexttest(@RequestParam("pid")Long pid){
        boolean next=iProjectService.update(new Project().setStage(5),Wrappers.<Project>lambdaQuery().eq(Project::getId,pid));
        return next?Msg.success():Msg.fail();
    }

    @PostMapping("nextDemandTest")
    public Msg nextDemandTest(@RequestParam("pid")Long pid){
        boolean next=iProjectService.update(new Project().setStage(6),Wrappers.<Project>lambdaQuery().eq(Project::getId,pid));
        return next?Msg.success():Msg.fail();
    }

}
