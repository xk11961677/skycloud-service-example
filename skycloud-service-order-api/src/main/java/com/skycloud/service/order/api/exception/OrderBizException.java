package com.skycloud.service.order.api.exception;

import com.skycloud.service.common.enums.ErrorCodeEnum;
import com.sky.framework.common.LogUtils;
import com.sky.framework.model.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;


/**
 * The class Order biz exception.
 *
 * @author
 */
@Slf4j
public class OrderBizException extends BusinessException {

	private static final long serialVersionUID = -6552248511084911254L;

	/**
	 * Instantiates a new Order rpc exception.
	 */
	public OrderBizException() {
	}

	/**
	 * Instantiates a new Order rpc exception.
	 *
	 * @param code      the code
	 * @param msgFormat the msg format
	 * @param args      the args
	 */
	public OrderBizException(int code, String msgFormat, Object... args) {
		super(code, msgFormat, args);
		LogUtils.info(log,"<== OmcRpcException, code:{}, message:{}", this.code, super.getMessage());
	}

	/**
	 * Instantiates a new Order rpc exception.
	 *
	 * @param code the code
	 * @param msg  the msg
	 */
	public OrderBizException(int code, String msg) {
		super(code, msg);
		LogUtils.info(log,"<== OrderRpcException, code:{}, message:{}", this.code, super.getMessage());
	}

	/**
	 * Instantiates a new Order rpc exception.
	 *
	 * @param codeEnum the code enum
	 */
	public OrderBizException(ErrorCodeEnum codeEnum) {
		super(codeEnum.code(), codeEnum.msg());
		LogUtils.info(log,"<== OrderRpcException, code:{}, message:{}", this.code, super.getMessage());
	}

}
