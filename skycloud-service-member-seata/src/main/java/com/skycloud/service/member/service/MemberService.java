package com.skycloud.service.member.service;

import com.sky.framework.mybatis.service.IService;
import com.skycloud.service.member.api.model.dto.MemberPwdUpdateDto;
import com.skycloud.service.member.model.domain.member.Member;

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
