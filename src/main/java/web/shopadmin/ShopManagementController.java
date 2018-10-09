package web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ShopExecution;
import entity.Area;
import entity.PersonInfo;
import entity.Shop;
import entity.ShopCategory;
import enums.ShopStateEnum;
import exceptions.ShopOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import service.AreaService;
import service.ShopCategoryService;
import service.ShopService;
import util.CodeUtil;
import util.HttpServletRequestUtil;
import util.ImageUtil;
import util.PathUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈简君
 * @date 2018/10/8 20:27
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

    private final ShopService shopService;

    private final ShopCategoryService shopCategoryService;

    private final AreaService areaService;

    @Autowired
    public ShopManagementController(ShopService shopService, ShopCategoryService shopCategoryService, AreaService areaService) {
        this.shopService = shopService;
        this.shopCategoryService = shopCategoryService;
        this.areaService = areaService;
    }

    @GetMapping("/getshopinitinfo")
    @ResponseBody
    private Map<String, Object> getShopInitInfo(){
        Map<String, Object> modelMap = new HashMap<>();
        List<ShopCategory> shopCategoryList = new ArrayList<>();
        List<Area> areaList = new ArrayList<>();
        try {
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @PostMapping("/registershop")
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<>();
        if (!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success", false);
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }
        //1.接受并转换相应的参数，包括店铺信息和图片信息
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        //2.注册店铺
        if (shop != null && shopImg != null){
            PersonInfo owner = new PersonInfo();
            //session TODO
            owner.setUserId(1L);
            shop.setOwner(owner);
            ShopExecution se;
            try {
                se = shopService.addShop(shop, shopImg.getInputStream(),shopImg.getOriginalFilename());
                if (se.getState() == ShopStateEnum.CHECK.getState()){
                    modelMap.put("success", true);
                }else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", se.getStateInfo());
                }
            }catch (ShopOperationException e){
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            } catch (IOException e) {
                modelMap.put("success", false);
                modelMap.put("errMsg", e.getMessage());
            }
            return modelMap;
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
            return modelMap;
        }
    }

//    private static void inputStreamToFile(InputStream ins, File file){
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream(file);
//            int bytesRead = 0;
//            byte[] buffer = new byte[1024];
//            while ((bytesRead = ins.read(buffer)) != -1){
//                os.write(buffer, 0, bytesRead);
//            }
//        } catch (Exception e){
//            throw new RuntimeException("调用InputStreamToFile产生异常:" + e.getMessage());
//        }finally {
//            try {
//                if (os != null){
//                    os.close();
//                }
//                if (ins != null){
//                    ins.close();
//                }
//            }catch (IOException e){
//                throw new RuntimeException("InputStreamToFile关闭IO产生异常:" + e.getMessage());
//            }
//        }
//    }
}
