package web.superadmin;

import entity.Area;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AreaController {

    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/listarea")
    @ResponseBody
    private Map<String, Object> listArea() {
        log.info("====start====");
        long startTime = System.currentTimeMillis();
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
        log.error("test error");
        long endTime = System.currentTimeMillis();
        log.debug("costTime:[{}ms]" , endTime - startTime);
        log.info("====end====");
        return modelMap;
    }
}
