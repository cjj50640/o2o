package web.superadmin;

import entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AreaService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 陈简君
 * @date 2018/10/3 21:36
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/listarea")
    @ResponseBody
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Area> list = new ArrayList<>();
        try {
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
