package com.ale.mp.strategy.kefu;


import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

/**
  *
  * @author alewu
  * @date 2020/8/26
  */
public interface KefuMsgBuildStrategy {

    /**
     * Build wx mp kefu message.
     *
     * @param msgContent the msg content
     * @return the wx mp kefu message
     */
    WxMpKefuMessage build(String msgContent);


    /**
     * Build custom wx mp kefu message.
     * //todo 构建跟用户相关的内容, 有需要再实现
     * @param openid     the openid
     * @param msgContent the msg content
     * @return the wx mp kefu message
     */
    default WxMpKefuMessage buildCustom(String openid, String msgContent) { return new WxMpKefuMessage();};
}
