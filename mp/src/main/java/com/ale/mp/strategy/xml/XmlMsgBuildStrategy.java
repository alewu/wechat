package com.ale.mp.strategy.xml;

import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

public interface XmlMsgBuildStrategy {
    WxMpXmlOutMessage build(String msgContent);
}
