
package com.cadillac.common.log.event;

import com.cadillac.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}

}
