package com.hrserver.service;

import com.hrserver.bean.Menu;
import com.hrserver.common.HrUtils;
import com.hrserver.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@CacheConfig(cacheNames = "menus_cache")
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu() {
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId() {
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public  List<Menu> menuTree() {
        return menuMapper.menuTree();
    }

    public List<Menu> getMenusByRid(Long rid) {
        return menuMapper.getMenusByRid(rid);
    }
}
