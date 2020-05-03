package com.swpu.asflow.service.impl;

import com.swpu.asflow.entity.Users;
import com.swpu.asflow.mapper.UsersMapper;
import com.swpu.asflow.service.IUsersService;
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
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
