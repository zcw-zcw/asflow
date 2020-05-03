package com.swpu.asflow.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Mail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swpu.asflow.entity.MailTable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
public interface IMailService extends IService<Mail> {
    public Page<MailTable> getMail(Page<MailTable> page, Long id);
}
