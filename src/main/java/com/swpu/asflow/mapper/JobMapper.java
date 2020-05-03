package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Job;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.asflow.entity.Jobtable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface JobMapper extends BaseMapper<Job> {
    public Page<Jobtable> getjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getmanajob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getcoderjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> gettestjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> gettestmanajob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> gettestcoderjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getdemandtestjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getdemandtestmanajob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getdemandtestcoderjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getmanagertocoderjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getmanagertocodertestjob(Page<Jobtable> page, Long uid, Long pid);
    public Page<Jobtable> getmanagertocoderdemandtestjob(Page<Jobtable> page, Long uid, Long pid);
}
