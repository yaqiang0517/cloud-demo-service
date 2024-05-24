package com.cloud.order.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.order.dao.po.RolePo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限-角色表 Mapper 接口
 * </p>
 *
 * @author meng.zhao
 * @since 2024-04-19
 */
@Mapper
public interface RoleMapper extends BaseMapper<RolePo> {

}
