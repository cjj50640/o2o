package dao;

import entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 陈简君
 * @date 2018/10/3 21:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件在哪
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        Assert.assertEquals(2, areaList.size());
    }
}