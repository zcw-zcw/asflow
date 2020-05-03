package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Department;
import com.swpu.asflow.entity.DptTable;
import com.swpu.asflow.mapper.DepartmentMapper;
import com.swpu.asflow.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<DptTable> getManager(long pid) {
        return departmentMapper.getManager(pid);
    }
    @Override
    public List<DptTable> getCoder(long pid,long uid) {
        return departmentMapper.getCoder(pid,uid);
    }
    @Override
    public Page<DptTable> getUser(Page<DptTable> page, List<Long> list,Long pid){
        return departmentMapper.getUser(page,list,pid);
    }

    @Override
    public Page<DptTable> getDepart(Page<DptTable> page, Long uid, Long pid) {
        return departmentMapper.getDepart(page,uid,pid);
    }
}
