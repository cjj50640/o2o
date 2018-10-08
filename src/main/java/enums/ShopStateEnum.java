package enums;

import lombok.Getter;

/**
 * @author 陈简君
 * @date 2018/10/5 20:44
 */
@Getter
public enum ShopStateEnum {
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法店铺"),
    SUCCESS(1, "操作成功"),
    PASS(2,"通过验证"),
    INNER_ERROR(-1001, "内部系统错误"),
    NULL_SHOPID(-1002,"ShopId为空"),
    NULL_SHOP(-1003, "shop信息为空")
    ;

    private int state;
    private String stateInfo;

    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state){
        for (ShopStateEnum stateEnum: values()){
            if (stateEnum.getState() == state){
                return stateEnum;
            }
        }
        return null;
    }
}
