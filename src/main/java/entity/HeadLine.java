package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 21:33
 */
@Data
public class HeadLine {

    private Long lineId;

    private String lineName;

    private String lineLink;

    private String lineImg;

    private Integer priority;

    /** 0.不可用1.可用 */
    private Integer enableStatus;

    private Date createTime;

    private Date lastEditTime;
}
