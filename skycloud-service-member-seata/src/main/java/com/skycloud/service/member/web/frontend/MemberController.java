package com.skycloud.service.member.web.frontend;

import com.skycloud.service.member.api.model.dto.MemberPwdUpdateDto;
import com.skycloud.service.member.mapper.member.SendMessageMapper;
import com.skycloud.service.member.model.domain.member.SendMessage;
import com.skycloud.service.member.service.MemberService;
import com.sky.framework.model.dto.MessageRes;
import com.sky.framework.web.support.BaseController;
import io.seata.spring.annotation.GlobalTransactional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;


/**
 * @author
 */
@RestController
@AllArgsConstructor
@RequestMapping("/member")
@Api(value = "WEB - MemberController", tags = "MemberController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MemberController extends BaseController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private SendMessageMapper sendMessageMapper;


    @ApiOperation(httpMethod = "POST", value = "修改密码")
    @PostMapping("/updatePassword")
    public MessageRes<String> updatePassword(@Valid @RequestBody MemberPwdUpdateDto param) {
        memberService.updatePassword(param);
        return MessageRes.success("登录密码修改成功后，请重新登录");
    }


    @ApiOperation(httpMethod = "POST", value = "新增")
    @PostMapping("/addSendMessage")
    @GlobalTransactional
    public MessageRes<Boolean> addSendMessage() {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setMobile("18918867071");
        sendMessageMapper.delete(sendMessage);
        sendMessage.setCount(1);
        sendMessage.setCreateDate(new Date());
        sendMessage.setFailCount(0);
        sendMessage.setModifyDate(new Date());
        sendMessageMapper.insertSelective(sendMessage);
        System.out.println("======>>ID :{}" + sendMessage.getId());
        return MessageRes.success(true);
    }
}
