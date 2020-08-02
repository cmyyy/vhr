package org.cmy.vhr.service;

import org.cmy.vhr.mapper.MenuMapper;
import org.cmy.vhr.model.Hr;
import org.cmy.vhr.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    /**
     * 找当前菜单下的子菜单
     * @return
     */
    public List<Menu> getMenusByHrId() {
        //getPrincipal获取到登录对象
        return menuMapper.getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    /**
     * 获取所有需要权限才能访问的菜单
     * @return
     */
//    @Cacheable//因为菜单一般不变，所以加缓存
    public List<Menu> getAllMenusWithRole(){
        return menuMapper.getAllMenusWithRole();
    }
}
