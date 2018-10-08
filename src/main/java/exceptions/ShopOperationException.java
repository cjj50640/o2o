package exceptions;

/**
 * @author 陈简君
 * @date 2018/10/8 20:05
 */
public class ShopOperationException extends RuntimeException {
    public ShopOperationException(String msg){
        super(msg);
    }
}
