package com.ale.mp.strategy.kefu;

import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.ImageBuilder;
import org.springframework.stereotype.Component;

@Component("poster")
public class PosterKefuMsgBuildStrategy implements KefuMsgBuildStrategy {
    @Override
    public WxMpKefuMessage build(String msgContent) {

        return new ImageBuilder().build();
    }
}
