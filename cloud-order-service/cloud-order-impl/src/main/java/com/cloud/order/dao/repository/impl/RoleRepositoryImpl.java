package com.cloud.order.dao.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.order.dao.mapper.RoleMapper;
import com.cloud.order.dao.po.RolePo;
import com.cloud.order.dao.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限-角色表 服务实现类
 * </p>
 *
 * @author meng.zhao
 * @since 2024-04-19
 */
@Service
public class RoleRepositoryImpl extends ServiceImpl<RoleMapper, RolePo> implements RoleRepository {

}
