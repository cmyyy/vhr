package org.cmy.vhr.controller.system;


import org.cmy.vhr.model.Hr;
import org.cmy.vhr.model.RespBean;
import org.cmy.vhr.model.Role;
import org.cmy.vhr.service.HrService;
import org.cmy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/hr")
public class HrController {
    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHrs(String keywords){
        return hrService.getAllHrs(keywords);
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        if (hrService.updateHr(hr)==1){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids){
        if (hrService.updateHrRole(hrid, rids)){
            return RespBean.ok("修改成功");
        }
        return RespBean.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable  Integer id){
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
