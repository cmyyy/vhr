# vhr


###p50 后端接口权限设计

用户发来请求路径，拿来和menu中的url匹配，找出对用的mid，
然后去menu_role中看哪些权限可以访问这个mid，也就是找rid，接着看用户id是否有相应rid权限，有，则可以访问，否，再见。
注意，一级菜单不分配rid。

###p52 完善权限管理
存在一个跨域的bug