package com.swpu.asflow.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.asflow.entity.DmdTable;
import com.swpu.asflow.entity.DptTable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface IDepartmentService extends IService<Department> {
    public Page<DptTable> getUser(Page<DptTable> page, List<Long> list,Long pid);
    public Page<DptTable> getDepart(Page<DptTable> page, Long uid,Long pid);
    public List<DptTable> getManager(long pid);
    public List<DptTable> getCoder(long pid,long uid);
}
