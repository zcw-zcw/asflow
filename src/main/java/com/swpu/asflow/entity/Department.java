package com.swpu.asflow.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zcw
 * @since 2020-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 部门id
     */
    private Long pid;

    /**
     * 担任角色0为管理员1为项目经理2为开发人员
     */
    private Integer role;

    /**
     * 所属的组的id
     */
    private Integer groupid;


}
