package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.asflow.entity.DptTable;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface DepartmentMapper extends BaseMapper<Department> {
public Page<DptTable> getUser(Page<DptTable> page, List<Long> list,Long pid);
    public Page<DptTable> getDepart(Page<DptTable> page, Long uid,Long pid);
    public List<DptTable> getManager(long pid);
    public List<DptTable> getCoder(long pid,long uid);
}
