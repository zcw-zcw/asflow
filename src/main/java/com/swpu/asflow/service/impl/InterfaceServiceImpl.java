package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Ifstable;
import com.swpu.asflow.entity.Interface;
import com.swpu.asflow.mapper.InterfaceMapper;
import com.swpu.asflow.service.IInterfaceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class InterfaceServiceImpl extends ServiceImpl<InterfaceMapper, Interface> implements IInterfaceService {
@Autowired
    InterfaceMapper interfaceMapper;

    @Override
    public Page<Ifstable> list(Page<Ifstable> page, Long pid) {
        return interfaceMapper.list(page,pid);
    }

    @Override
    public Page<Interface> getallint(Page<Interface> page,Long pid) {
        return interfaceMapper.getallint(page,pid);
    }

    @Override
    public List<Interface> getint(Long pid) {
        return interfaceMapper.getint(pid);
    }
}
