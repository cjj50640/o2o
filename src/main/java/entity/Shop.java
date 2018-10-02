package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 21:44
 */
@Data
public class Shop {

    private Long shopId;

    private String shopName;

    private String shopDesc;

    private String shopAddr;

    private String phone;

    private String shopImg;

    private Integer priority;

    private Date createTime;

    private Date lastEditTime;

    /** -1.不可用0.审核中1.可用 */
    private Integer enableStatus;

    /** 超级管理员给店铺的建议 */
    private String advice;

    private Area area;

    private PersonInfo owner;

    private ShopCategory shopCategory;
}
