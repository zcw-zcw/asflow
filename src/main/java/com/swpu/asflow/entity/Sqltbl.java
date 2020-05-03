package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Sqltbl implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 接口id
     */
    @TableField("pid")
    private Long pid;

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


}
