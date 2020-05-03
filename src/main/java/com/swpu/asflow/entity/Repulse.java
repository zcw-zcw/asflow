package com.swpu.asflow.entity;

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
public class Repulse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    private Long jid;

    /**
     * 打回原因
     */
    private String reason;

    /**
     * 打回时间
     */
    private LocalDateTime time;


}
