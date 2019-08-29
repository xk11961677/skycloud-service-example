package com.skycloud.service.member.api.service;

import com.skycloud.base.common.feign.CustomFeignAutoConfiguration;
import com.skycloud.service.common.constant.FeginConstant;
import com.skycloud.service.member.api.service.factory.AdUserFeignFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author
 */
@FeignClient(name = FeginConstant.MEMBER, configuration = CustomFeignAutoConfiguration.class, fallbackFactory = AdUserFeignFallbackFactory.class)
public interface AdUserFeignApi {


}
