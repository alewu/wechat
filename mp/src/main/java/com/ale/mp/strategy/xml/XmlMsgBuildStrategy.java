package com.ale.mp.strategy.xml;

import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * The interface Xml msg build strategy.
 *
 * @author alewu
 * @date 2020 /8/26
 */
public interface XmlMsgBuildStrategy {
    /**
     * Build wx mp xml out message.
     *
     * @param msgContent the msg content
     * @return the wx mp xml out message
     */
    WxMpXmlOutMessage build(String msgContent);
}
