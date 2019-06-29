package com.hrserver.mapper;

import com.hrserver.bean.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();

    List<Menu> getMenusByRid(Long rid);
}
