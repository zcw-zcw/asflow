package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.ModTable;
import com.swpu.asflow.entity.Model;
import com.swpu.asflow.mapper.ModelMapper;
import com.swpu.asflow.service.IModelService;
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
public class ModelServiceImpl extends ServiceImpl<ModelMapper, Model> implements IModelService {
    @Autowired
    ModelMapper modelMapper;
    @Override
    public Page<ModTable> getModel(Page<ModTable> page, List<Long> list) {
        return modelMapper.getModel(page,list);
    }
}
