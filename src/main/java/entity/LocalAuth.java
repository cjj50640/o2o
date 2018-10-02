package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 21:22
 */
@Data
public class LocalAuth {

    private Long localAuthId;

    private String username;

    private String password;

    private Date createTime;

    private Date lastEditTime;

    private PersonInfo personInfo;
}
