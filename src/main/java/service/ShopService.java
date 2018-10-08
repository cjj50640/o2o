package service;

import dto.ShopExecution;
import entity.Shop;

import java.io.InputStream;

/**
 * @author 陈简君
 * @date 2018/10/8 19:35
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
