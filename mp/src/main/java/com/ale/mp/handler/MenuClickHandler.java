package com.ale.mp.handler;

import com.ale.mp.strategy.xml.XmlMsgStrategyContext;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static me.chanjar.weixin.common.api.WxConsts.EventType;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MenuClickHandler extends AbstractHandler {
    @Autowired
    private XmlMsgStrategyContext xmlMsgStrategyContext;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        String msg = String.format("type:%s, event:%s, key:%s",
                                   wxMessage.getMsgType(), wxMessage.getEvent(),
                                   wxMessage.getEventKey());
        return xmlMsgStrategyContext.getStrategy("").build(msg);
    }

}
