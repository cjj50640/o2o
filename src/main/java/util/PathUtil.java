package util;

/**
 * @author 陈简君
 * @date 2018/10/5 20:14
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "E:/images/";
        }else {
            basePath = "/home/chen/image/";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }
    public static String getShopImagePath(long shopId){
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
