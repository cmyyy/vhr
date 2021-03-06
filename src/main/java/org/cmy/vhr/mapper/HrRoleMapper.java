package org.cmy.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.cmy.vhr.model.HrRole;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    Integer addRole(Integer hrid, @Param("rids") Integer[] rids);

    void deleteByHrid(Integer hrid);
}