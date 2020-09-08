package com.ale.mp.handler.in;

import com.ale.mp.strategy.XmlMsgStrategyContext;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {
    @Autowired
    private XmlMsgStrategyContext xmlMsgStrategyContext;
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        // 处理用户发送信息
        String content = wxMessage.getContent();
        // 回复相应的内容
        return xmlMsgStrategyContext.getStrategy(wxMessage.getMsgType()).build(content);
    }

}
