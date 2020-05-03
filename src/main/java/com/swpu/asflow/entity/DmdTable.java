package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DmdTable implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 需求id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目id
     */
    private Long pid;

    /**
     * 添加人id
     */
    private Long uid;

    /**
     * 添加时间
     */
    private LocalDateTime time;

    /**
     * 需求标题
     */
    private String title;

    /**
     * 需求内容
     */
    private String content;

    /**
     * 状态0为待定1为确定2为删除
     */
    private Integer flag;

    private String name;

    private int testFlag;
}
