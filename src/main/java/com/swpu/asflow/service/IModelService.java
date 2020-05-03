package com.swpu.asflow.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.ModTable;
import com.swpu.asflow.entity.Model;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface IModelService extends IService<Model> {
    public Page<ModTable> getModel(Page<ModTable> page, List<Long> list);
}
