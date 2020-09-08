package com.ale.mp.strategy.kefu;

import com.ale.mp.strategy.KefuMsgBuildStrategy;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.ImageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("poster")
public class PosterKefuMsgBuildStrategy implements KefuMsgBuildStrategy {
    @Autowired
    private ImageKefuMsgBuildStrategy imageKefuMsgBuildStrategy;

    @Override
    public WxMpKefuMessage build(String msgContent) {
        imageKefuMsgBuildStrategy.build(msgContent);
        return new ImageBuilder().build();
    }
}
