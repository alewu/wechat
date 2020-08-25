package com.ale.mp.strategy.kefu;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.VideoBuilder;
import org.springframework.stereotype.Component;

@Component(WxConsts.KefuMsgType.VIDEO)
public class VideoKefuMsgBuildStrategy implements KefuMsgBuildStrategy {

    @Override
    public WxMpKefuMessage build(String msgContent) {
        return new VideoBuilder().mediaId(msgContent).description("").thumbMediaId(msgContent).build();
    }
}
