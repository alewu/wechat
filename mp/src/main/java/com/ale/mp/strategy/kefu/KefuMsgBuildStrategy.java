package com.ale.mp.strategy.kefu;


import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;

public interface KefuMsgBuildStrategy {

    WxMpKefuMessage build(String msgContent);
}
