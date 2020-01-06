package com.skycloud.service.member.mapper.member;

import com.sky.framework.mybatis.MyMapper;
import com.skycloud.service.member.model.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author
 */
@Mapper
@Repository
public interface MemberMapper extends MyMapper<Member> {


}
