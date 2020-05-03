package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 测试截图id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 接口id
     */
    @TableField("Iid")
    private Long Iid;

    /**
     * 截图链接
     */
    private String url;

    /**
     * 上传者id
     */
    private Long uid;

    /**
     * 上传时间
     */
    private LocalDateTime time;

    /**
     * 描述
     */
    private String disc;
    private Integer  type;
    private Integer did;

}
