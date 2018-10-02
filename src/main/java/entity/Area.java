package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 20:57
 */
@Data
public class Area {

    /** id */
    private Integer areaId;

    /** 名称 */
    private String areaName;

    /** 权重 */
    private Integer priority;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date lastEditTime;
}
