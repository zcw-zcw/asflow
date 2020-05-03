package com.swpu.asflow.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Demand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.asflow.entity.DmdTable;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface IDemandService extends IService<Demand> {
    public Page<DmdTable> getDemand(Page<DmdTable> page, List<Long> list);
}
