package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
public class Interface implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接口id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建人id
     */
    private Long uid;

    /**
     * 创建时间
     */
    private LocalDateTime time;

    /**
     * 模块id
     */
    private Long mid;

    /**
     * 参数
     */
    private String parameter;

    /**
     * 返回
     */
    private String returnss;



    /**
     * 接口描述
     */
    private String disc;

    private Integer flag;
    private String title;
    private Integer  testFlag;
}
