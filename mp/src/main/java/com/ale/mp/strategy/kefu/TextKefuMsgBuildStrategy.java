package com.ale.mp.strategy.kefu;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.TextBuilder;
import org.springframework.stereotype.Component;

@Component(WxConsts.KefuMsgType.TEXT)
public class TextKefuMsgBuildStrategy implements KefuMsgBuildStrategy {
    @Override
    public WxMpKefuMessage build(String msgContent) {
        return new TextBuilder().content(msgContent).build();
    }
}
