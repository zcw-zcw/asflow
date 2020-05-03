package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Ifstable;
import com.swpu.asflow.entity.Interface;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface InterfaceMapper extends BaseMapper<Interface> {
    public Page<Ifstable> list(Page<Ifstable> page, Long pid);
    public Page<Interface> getallint(Page<Interface> page,Long pid);
    public List<Interface> getint(Long pid);
}
