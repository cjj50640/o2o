package service;

import entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 陈简君
 * @date 2018/10/3 21:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件在哪
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void getAreaList() {
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals("西苑", areaList.get(0).getAreaName());
    }
}