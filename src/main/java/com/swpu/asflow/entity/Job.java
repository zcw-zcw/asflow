package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发布人id
     */
    private Long formid;

    /**
     * 接收人id
     */
    private Long getid;

    /**
     * 任务描述
     */
    private String disc;

    /**
     * 创建时间
     */
    private LocalDateTime creatTime;

    /**
     * 最迟时间
     */
    private LocalDateTime finalTime;

    /**
     * 提交时间
     */
    private LocalDateTime subTime;

    /**
     * 标记0为未提交1为提交但未完成2为提交完毕3为再次提交
     */
    private Integer flag;

    /**
     * 完成百分比
     */
    private Integer completion;

    /**
     * 是否上传1为上传0为未上传
     */
    private Integer subFlag;

    private Long iid;
private Long pid;
private Long coderid;
private Long subid;
private Integer type;
private Long did;
    private LocalDateTime finalTimeManager;
}
