package com.ale.wechat.service.internal;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ale
 */
@Service
@Slf4j
@AllArgsConstructor
public class WxMpTemplateMessageSendService {
    private final WxMpService wxService;

    public String sendTemplateMsg(String user, String templateId, List<WxMpTemplateData> templateDataList) {
        // 1、构建模板消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                                                                 .toUser(user)
                                                                 .templateId(templateId)
                                                                 .build();
        // 2、设置模板数据
        templateMessage.setData(templateDataList);
        // 3、发送模板消息
        String msgId = "";
        try {
             msgId = wxService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error(e.getMessage(), e);
        }
        return msgId;
    }
}
