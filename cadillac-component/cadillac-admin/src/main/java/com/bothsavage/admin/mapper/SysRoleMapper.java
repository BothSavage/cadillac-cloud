
package com.cadillac.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cadillac.admin.api.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *

 * @since 2017-10-29
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

	/**
	 * 通过用户ID，查询角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> listRolesByUserId(Long userId);

}
