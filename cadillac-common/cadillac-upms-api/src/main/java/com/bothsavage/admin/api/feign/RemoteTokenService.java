

package com.cadillac.admin.api.feign;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cadillac.common.core.constant.SecurityConstants;
import com.cadillac.common.core.constant.ServiceNameConstants;
import com.cadillac.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 * @date 2018/9/4
 */
@FeignClient(contextId = "remoteTokenService", value = ServiceNameConstants.AUTH_SERVICE)
public interface RemoteTokenService {

	/**
	 * 分页查询token 信息
	 * @param from 内部调用标志
	 * @param params 分页参数
	 * @param from 内部调用标志
	 * @return page
	 */
	@PostMapping("/token/page")
	R<Page> getTokenPage(@RequestBody Map<String, Object> params, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 删除token
	 * @param from 内部调用标志
	 * @param token token
	 * @param from 内部调用标志
	 * @return
	 */
	@DeleteMapping("/token/{token}")
	R<Boolean> removeTokenById(@PathVariable("token") String token, @RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 校验令牌获取用户信息
	 * @param token
	 * @param from
	 * @return
	 */
	@GetMapping("/token/query-token")
	R<Map<String, Object>> queryToken(@RequestParam("token") String token,
			@RequestHeader(SecurityConstants.FROM) String from);

}
