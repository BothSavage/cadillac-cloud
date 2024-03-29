
package com.cadillac.admin.api.feign;

import com.cadillac.admin.api.entity.SysOauthClientDetails;
import com.cadillac.common.core.constant.SecurityConstants;
import com.cadillac.common.core.constant.ServiceNameConstants;
import com.cadillac.common.core.util.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

/**

 * @date 2020/12/05
 */
@FeignClient(contextId = "remoteClientDetailsService", value = ServiceNameConstants.UMPS_SERVICE)
public interface RemoteClientDetailsService {

	/**
	 * 通过clientId 查询客户端信息
	 * @param clientId 用户名
	 * @param from 调用标志
	 * @return R
	 */
	@GetMapping("/client/getClientDetailsById/{clientId}")
	R<SysOauthClientDetails> getClientDetailsById(@PathVariable("clientId") String clientId,
			@RequestHeader(SecurityConstants.FROM) String from);

	/**
	 * 查询全部客户端
	 * @param from 调用标识
	 * @return R
	 */
	@GetMapping("/client/list")
	R<List<SysOauthClientDetails>> listClientDetails(@RequestHeader(SecurityConstants.FROM) String from);

}
