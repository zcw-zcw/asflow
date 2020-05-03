package com.swpu.asflow.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class Ifstable implements Serializable {
    private long mid;
    private String  mname;
    private String mdis;
    private String dname;
    private int  flag;
    private int  testFlag;
    private String uname;
    private String time;

}
