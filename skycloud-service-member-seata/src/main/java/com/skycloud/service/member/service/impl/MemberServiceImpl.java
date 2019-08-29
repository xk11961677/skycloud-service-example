package com.skycloud.service.member.service.impl;

import com.skycloud.service.member.api.model.dto.MemberPwdUpdateDto;
import com.skycloud.service.member.mapper.life.AdUserMapper;
import com.skycloud.service.member.mapper.member.MemberMapper;
import com.skycloud.service.member.model.domain.life.AdUser;
import com.skycloud.service.member.model.domain.member.Member;
import com.skycloud.service.member.service.MemberService;
import com.sky.framework.common.encrypt.Md5Utils;
import com.sky.framework.model.enums.FailureCodeEnum;
import com.sky.framework.model.exception.BusinessException;
import com.sky.framework.web.support.BaseService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @author code generator
 * @date 2019-06-15 15:01:41
 */
@Service("memberService")
@Slf4j
public class MemberServiceImpl extends BaseService<Member> implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private AdUserMapper adUserMapper;

    @Override
    public Member getMemberByUserId(Long userId, String deleteFlg) {
        Example example = new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adId", userId);
        if (!StringUtils.isEmpty(deleteFlg)) {
            criteria.andEqualTo("deleteFlg", deleteFlg);
        }
        Member member = memberMapper.selectOneByExample(example);
        return member;
    }

    @Override
    public void updatePassword(MemberPwdUpdateDto param) {
        Long userId = 88442610L;
        Member member = getMemberByUserId(userId, null);
        String md5Pwd = Md5Utils.encode(param.getNewPassword());
        ((MemberServiceImpl)AopContext.currentProxy()).updatePassword(member.getId(), userId, md5Pwd);
    }

    /**
     * 修改密码
     *
     * @param memberId
     * @param userId
     * @param md5Pwd
     */
    @GlobalTransactional
    public void updatePassword(Long memberId, Long userId, String md5Pwd) {
        Member member = new Member();
        member.setId(memberId);
        member.setPassword(md5Pwd);
        member.setModifyDate(new Date());
        memberMapper.updateByPrimaryKeySelective(member);
        AdUser user = new AdUser();
        user.setId(userId);
        user.setPassword(md5Pwd);
        user.setUpdateDate(new Date());
        adUserMapper.updateByPrimaryKeySelective(user);

        throw new BusinessException(FailureCodeEnum.GL999998.getCode(), FailureCodeEnum.GL999998.getMsg());
    }


}
