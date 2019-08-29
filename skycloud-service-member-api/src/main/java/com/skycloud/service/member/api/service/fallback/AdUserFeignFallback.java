package com.skycloud.service.member.api.service.fallback;

import com.skycloud.service.member.api.service.AdUserFeignApi;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 */
//@Component
@Slf4j
public class AdUserFeignFallback implements AdUserFeignApi {

    @Setter
    private Throwable cause;


}
