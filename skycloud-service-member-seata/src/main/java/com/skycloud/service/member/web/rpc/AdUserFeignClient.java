package com.skycloud.service.member.web.rpc;

import com.skycloud.service.member.api.service.AdUserFeignApi;
import com.sky.framework.web.support.BaseController;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 */
@RestController
@Api(value = "API - AdUserFeignClient",tags = "AdUserFeignClient", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdUserFeignClient extends BaseController implements AdUserFeignApi {


}
