package com.skycloud.service.member.service;

import com.skycloud.service.member.api.model.dto.MemberPwdUpdateDto;
import com.skycloud.service.member.model.domain.member.Member;
import com.sky.framework.web.support.IService;

/**
 * @author code generator
 * @date 2019-06-15 15:01:41
 */
public interface MemberService extends IService<Member> {

    /**
     *
     * @param userId
     * @param deleteFlg
     * @return
     */
    Member getMemberByUserId(Long userId, String deleteFlg);

    /**
     * 修改密码
     *
     * @param param
     */
    void updatePassword(MemberPwdUpdateDto param);

}
