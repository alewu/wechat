package com.ale.mp.strategy.kefu;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.ImageBuilder;
import org.springframework.stereotype.Component;

@Component(WxConsts.KefuMsgType.IMAGE)
public class ImageKefuMsgBuildStrategy implements KefuMsgBuildStrategy {

    @Override
    public WxMpKefuMessage build(String msgContent) {
        return new ImageBuilder().mediaId(msgContent).build();
    }
}
