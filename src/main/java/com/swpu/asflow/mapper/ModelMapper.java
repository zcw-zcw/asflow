package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.DmdTable;
import com.swpu.asflow.entity.ModTable;
import com.swpu.asflow.entity.Model;
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
public interface ModelMapper extends BaseMapper<Model> {
    public Page<ModTable> getModel(Page<ModTable> page, List<Long> list);
}
