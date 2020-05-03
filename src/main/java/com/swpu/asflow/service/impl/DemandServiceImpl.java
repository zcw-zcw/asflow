package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Demand;
import com.swpu.asflow.entity.DmdTable;
import com.swpu.asflow.mapper.DemandMapper;
import com.swpu.asflow.service.IDemandService;
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
public class DemandServiceImpl extends ServiceImpl<DemandMapper, Demand> implements IDemandService {
    @Autowired
    DemandMapper demandMapper;
    @Override
    public Page<DmdTable> getDemand(Page<DmdTable> page, List<Long> list) {
        return demandMapper.getDemand(page,list);
    }
}
