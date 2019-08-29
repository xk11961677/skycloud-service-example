package com.skycloud.service.member.mapper.member;

import com.skycloud.service.member.model.domain.member.SendMessage;
import com.sky.framework.web.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author
 */
@Mapper
@Repository
public interface SendMessageMapper extends MyMapper<SendMessage> {


}
