package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Job;
import com.swpu.asflow.entity.Jobtable;
import com.swpu.asflow.mapper.JobMapper;
import com.swpu.asflow.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {
    @Autowired
    JobMapper jobMapper;

    @Override
    public Page<Jobtable> getjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getcoderjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getcoderjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getmanajob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getmanajob(page,uid,pid);
    }
    @Override
    public Page<Jobtable> gettestjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.gettestjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> gettestcoderjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.gettestcoderjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> gettestmanajob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.gettestmanajob(page,uid,pid);
    }
    @Override
    public Page<Jobtable> getdemandtestjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getdemandtestjob(page,uid,pid);
    }
    @Override
    public Page<Jobtable> getdemandtestcoderjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getdemandtestcoderjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getmanagertocodertestjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getmanagertocodertestjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getmanagertocoderjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getmanagertocoderjob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getdemandtestmanajob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getdemandtestmanajob(page,uid,pid);
    }

    @Override
    public Page<Jobtable> getmanagertocoderdemandtestjob(Page<Jobtable> page, Long uid, Long pid) {
        return jobMapper.getmanagertocoderdemandtestjob(page,uid,pid);
    }
}
