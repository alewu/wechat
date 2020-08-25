package com.ale.mp.strategy.xml;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

@Component("xml_" + WxConsts.XmlMsgType.TEXT)
public class TextXmlMsgBuildStrategy implements XmlMsgBuildStrategy {
    @Override
    public WxMpXmlOutMessage build(String msgContent) {
        return WxMpXmlOutMessage.TEXT().fromUser("").toUser("").content(msgContent).build();
    }
}
