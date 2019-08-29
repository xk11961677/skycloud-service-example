package com.skycloud.service.member.mapper.life;

import com.sky.framework.web.mybatis.MyMapper;
import com.skycloud.service.member.model.domain.life.AdUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 会员信息表
 *
 * @author
 */
@Mapper
@Repository
public interface AdUserMapper extends MyMapper<AdUser> {


}
