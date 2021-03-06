package com.ale.mp.strategy.xml;

import com.ale.mp.strategy.XmlMsgBuildStrategy;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

/**
  *
  * @author alewu
  * @date 2020/8/26
  */
@Component("xml_" + WxConsts.XmlMsgType.IMAGE)
public class ImageXmlMsgBuildStrategy implements XmlMsgBuildStrategy {
    @Override
    public WxMpXmlOutMessage build(String msgContent) {
        return WxMpXmlOutMessage.IMAGE().fromUser("").toUser("").mediaId(msgContent).build();
    }
}
