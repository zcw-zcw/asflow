package com.swpu.asflow.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swpu.asflow.entity.Mail;
import com.swpu.asflow.entity.MailTable;
import com.swpu.asflow.mapper.MailMapper;
import com.swpu.asflow.service.IMailService;
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
public class MailServiceImpl extends ServiceImpl<MailMapper, Mail> implements IMailService {
    @Autowired
    MailMapper mailMapper;
    @Override
    public Page<MailTable> getMail(Page<MailTable> page, Long id) {
        return mailMapper.getMail(page,id);
    }
}
