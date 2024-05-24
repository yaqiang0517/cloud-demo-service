package com.cloud.order.dao.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 权限-角色表
 * </p>
 *
 * @author meng.zhao
 * @since 2024-04-19
 */
@Getter
@Setter
@TableName("role")
public class RolePo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     **/
    @TableId(type = IdType.ASSIGN_ID)
    private Long roleId;

    /**
     * 名称
     **/
    private String roleName;

    /**
     * 门户 1 运营门户 2 运维门户
     **/
    private Integer rolePortal;
    /**
     * 全部管理域权限：1全部、2部分
     **/
    private Integer allDataSet;

    /**
     * 分销客户账号id
     **/
    private String roleDesc;

    /**
     * 创建人姓名快照
     **/
    private String createBy;

    /**
     * 更新人姓名快照
     **/
    private String updateBy;

    /**
     * 创建时间
     **/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     **/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 0 存在 1 已删除
     **/
    @TableLogic
    private Integer deleted;


}
