

package com.bothSavage.common.file.oss;

import com.bothSavage.common.file.core.FileProperties;
import com.bothSavage.common.file.core.FileTemplate;
import com.bothSavage.common.file.oss.http.OssEndpoint;
import com.bothSavage.common.file.oss.service.OssTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * aws 自动配置类
 *


 */
@AllArgsConstructor
public class OssAutoConfiguration {

	private final FileProperties properties;

	@Bean
	@Primary
	@ConditionalOnMissingBean(OssTemplate.class)
	@ConditionalOnProperty(name = "file.oss.enable", havingValue = "true")
	public FileTemplate ossTemplate() {
		return new OssTemplate(properties);
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnProperty(name = "file.oss.info", havingValue = "true")
	public OssEndpoint ossEndpoint(OssTemplate template) {
		return new OssEndpoint(template);
	}

}
