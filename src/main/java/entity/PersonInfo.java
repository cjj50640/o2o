package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 21:10
 */
@Data
public class PersonInfo {

    private Long userId;

    private String name;

    private String profileImg;

    private String email;

    private String gender;

    private Integer enableStatus;

    /** 1.顾客2.商家3.超级管理员 */
    private Integer userType;

    private Date createTime;

    private Date lastEditTime;
}
