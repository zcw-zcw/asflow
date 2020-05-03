package com.swpu.asflow.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Department;
import com.swpu.asflow.entity.DptTable;
import com.swpu.asflow.entity.Users;
import com.swpu.asflow.service.IDepartmentService;
import com.swpu.asflow.service.IUsersService;
import com.swpu.asflow.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    IDepartmentService iDepartmentService;
    @Autowired
    IUsersService iUsersService;
    @RequestMapping("getUser")
    public Map getUser(@RequestParam("pid") Long pid,
                       @RequestParam("uid") Long uid,
                       @RequestParam("page") Integer page,
                       @RequestParam("limit") Integer limit){
        List<Department> list=iDepartmentService.list(Wrappers.<Department>lambdaQuery().eq(Department::getPid,pid).ne(Department::getRole,0));
        ArrayList<Long> longs=new ArrayList<>();
        for(Department department1:list){
            longs.add(department1.getUid());
        }
        Page<DptTable> pageArt=new Page<DptTable>(page,limit);
        Page<DptTable> page1 = iDepartmentService.getUser(pageArt,longs,pid);

            return new HashMap<String, Object>() {{
                put("code", 0);
                put("msg", "SUCCESS");
                put("count", page1.getTotal());
                put("data", page1.getRecords());
            }};
//        }

    }

    @GetMapping("getManager")
    public Msg getManager(@RequestParam("pid")Long pid){
        return Msg.success().add("tip",iDepartmentService.getManager(pid));
    }
    @GetMapping("getCoder")
    public Msg getCoder(@RequestParam("pid")Long pid,@RequestParam("uid")Long uid){
        return Msg.success().add("tip",iDepartmentService.getCoder(pid,uid));
    }
    @PostMapping("changeUser")
    public Msg changeUser(@RequestParam("uid")Long uid,
                          @RequestParam("role")Integer role,
                          @RequestParam("groupid")Integer groupid){
        if(uid==null||role.equals(0)||groupid.equals(0)){
            return Msg.fail().add("tip","信息不完整");
        }
        boolean changeUser=iDepartmentService.update(new Department().setGroupid(groupid).setRole(role),Wrappers.<Department>lambdaQuery().eq(Department::getUid,uid));
       return changeUser ?  Msg.success().add("tip","修改成功") : Msg.fail().add("tip","修改失败");
    }

    @PostMapping("deleteUser")
    public Msg deleteUser(@RequestParam("id")Long id,@RequestParam("uid")Long uid,@RequestParam("pid")Long pid){
        Department department=iDepartmentService.getOne(Wrappers.<Department>lambdaQuery().eq(Department::getPid,pid).eq(Department::getUid,id).eq(Department::getRole,0));
        if(department==null){
            return Msg.fail().add("tip","没有操作权限");
        }
        boolean delete=iDepartmentService.remove(Wrappers.<Department>lambdaQuery().eq(Department::getUid,uid));
        return delete?Msg.success().add("tip","删除成功"):Msg.fail().add("tip","删除失败");
    }

    @GetMapping("getDepart")
    public Map getDepart(@RequestParam("uid")Long uid, @RequestParam("pid")Long pid, @RequestParam("page") Integer page,
                                         @RequestParam("limit") Integer limit){

        Page<DptTable> pageArt=new Page<DptTable>(page,limit);
        Page<DptTable> page1 = iDepartmentService.getDepart(pageArt,uid,pid);

        return new HashMap<String, Object>() {{
            put("code", 0);
            put("msg", "SUCCESS");
            put("count", page1.getTotal());
            put("data", page1.getRecords());
        }};
    }

    /***
     * 添加成员
     * @param uid
     * @param role
     * @param groupid
     * @return
     */
    @PostMapping("add")
    public Msg add(@RequestParam("uid")Long uid,
                          @RequestParam("role")Integer role,
                          @RequestParam("groupid")Integer groupid,
                   @RequestParam("phone")String phone,
                   @RequestParam("pid")Long pid){
        if(uid==null||role.equals(0)||groupid.equals(0)||phone==null){
            return Msg.fail().add("tip","信息不完整");
        }
        Users users=iUsersService.getOne(Wrappers.<Users>lambdaQuery().eq(Users::getPhone,phone));
        if(users==null){
            return Msg.fail().add("tip","用户不存在");
        }
        boolean add=iDepartmentService.save(new Department().setGroupid(groupid).setRole(role).setUid(users.getId()).setPid(pid));
        return add ?  Msg.success().add("tip","添加成功") : Msg.fail().add("tip","添加失败");
    }
}
