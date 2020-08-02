package org.cmy.vhr.controller;

import org.cmy.vhr.model.Menu;
import org.cmy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;
    //前端传来的数据不可信，因为可能用postman传来的，绕过了前端的校验。所以，后端不能用前端传过来的参数，要取保存在内存中的数据
    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusByHrId();
    }
}
