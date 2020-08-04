package org.cmy.vhr.controller.system.basic;

import org.cmy.vhr.model.Menu;
import org.cmy.vhr.model.RespBean;
import org.cmy.vhr.model.Role;
import org.cmy.vhr.service.MenuService;
import org.cmy.vhr.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    /**
     * 通过rid查找mid,得到rid有权访问的mid
     * @param rid
     * @return
     */
    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    /**
     * 更新rid 有权访问的mid。 这里的做法是先删除整行，再插入。所以在Menuservice中的函数上要加@transactional，避免删除成功了但插入失败。
     * @param rid
     * @param mids
     * @return
     */
    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid, Integer[] mids){
        if (menuService.updateMenuRole(rid, mids)){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRoleById(@PathVariable Integer rid){
        if (roleService.deleteRoleById(rid) == 1){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
