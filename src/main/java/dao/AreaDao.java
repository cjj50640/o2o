package dao;

import entity.Area;

import java.util.List;

/**
 * @author 陈简君
 * @date 2018/10/3 21:06
 */
public interface AreaDao {

    /**
     * 列出区域列表
     * @return areaList
     */
    List<Area> queryArea();
}
