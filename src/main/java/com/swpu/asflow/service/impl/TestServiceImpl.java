package com.swpu.asflow.service.impl;

import com.swpu.asflow.entity.Test;
import com.swpu.asflow.mapper.TestMapper;
import com.swpu.asflow.service.ITestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

}
