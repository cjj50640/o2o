package service.impl;

import dao.AreaDao;
import entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AreaService;

import java.util.List;

/**
 * @author 陈简君
 * @date 2018/10/3 21:28
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
