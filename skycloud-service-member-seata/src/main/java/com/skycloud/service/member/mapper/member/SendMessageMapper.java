package com.skycloud.service.member.mapper.member;

import com.sky.framework.mybatis.MyMapper;
import com.skycloud.service.member.model.domain.member.SendMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author
 */
@Mapper
@Repository
public interface SendMessageMapper extends MyMapper<SendMessage> {


}
