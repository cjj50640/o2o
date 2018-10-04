package dao;

import entity.Shop;

/**
 * @author 陈简君
 * @date 2018/10/4 20:13
 */
public interface ShopDao {
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
