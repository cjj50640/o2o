package entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 陈简君
 * @date 2018/10/2 22:04
 */
@Data
public class Product {

    private Long productId;

    private String productName;

    private String productDesc;

    /** 简略图 */
    private String imgAddr;

    private String normalPrice;

    private String promotionPrice;

    private Date createTime;

    private Date lastEditTime;

    /** 0.下架1.在前端展示系统展示 */
    private Integer enableStatus;

    private List<ProductImg> productImgList;

    private ProductCategory productCategory;

    private Shop shop;
}
