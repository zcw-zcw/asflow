package com.swpu.asflow.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Mail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swpu.asflow.entity.MailTable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface MailMapper extends BaseMapper<Mail> {
    public Page<MailTable> getMail(Page<MailTable> page, Long id);
}
