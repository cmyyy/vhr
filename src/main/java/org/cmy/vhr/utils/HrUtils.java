package org.cmy.vhr.utils;

import org.cmy.vhr.model.Hr;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * 获取当前登录对象
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
