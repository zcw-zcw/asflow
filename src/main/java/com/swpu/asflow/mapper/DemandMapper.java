package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Demand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.asflow.entity.DmdTable;
import com.swpu.asflow.entity.DptTable;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface DemandMapper extends BaseMapper<Demand> {
    public Page<DmdTable> getDemand(Page<DmdTable> page, List<Long> list);

}
