package com.swpu.asflow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class MailTable implements Serializable {

        private static final long serialVersionUID = 1L;

        /**
         * 邮件id
         */
        @TableId(value = "id", type = IdType.AUTO)
        private Long id;

        /**
         * 发送者id
         */
        private Long sentid;
        private int flag;
        /**
         * 接收者id
         */
        private Long getid;

        /**
         * 时间
         */
        private LocalDateTime time;

        /**
         * 内容
         */
        private String cont;

        private String name;

    private String title;
}
