package com.swpu.asflow.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Ifstable;
import com.swpu.asflow.entity.Interface;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.asflow.entity.MailTable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface IInterfaceService extends IService<Interface> {
    public Page<Ifstable> list(Page<Ifstable> page, Long pid);
    public Page<Interface> getallint(Page<Interface> page,Long pid);
    public List<Interface> getint(Long pid);
}
