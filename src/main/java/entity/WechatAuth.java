package entity;

import lombok.Data;

import java.util.Date;

/**
 * @author 陈简君
 * @date 2018/10/2 21:21
 */
@Data
public class WechatAuth {

    private Long wechatAuthId;

    private String openId;

    private Date createTime;

    private PersonInfo personInfo;
}
