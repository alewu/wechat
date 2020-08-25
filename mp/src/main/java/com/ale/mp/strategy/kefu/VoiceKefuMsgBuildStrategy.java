package com.ale.mp.strategy.kefu;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.VoiceBuilder;
import org.springframework.stereotype.Component;

@Component(WxConsts.KefuMsgType.VOICE)
public class VoiceKefuMsgBuildStrategy implements KefuMsgBuildStrategy {
    @Override
    public WxMpKefuMessage build(String msgContent) {
        return new VoiceBuilder().mediaId(msgContent).build();
    }
}
