package service;

import entity.ShopCategory;

import java.util.List;

/**
 * @author 陈简君
 * @date 2018/10/9 20:24
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
