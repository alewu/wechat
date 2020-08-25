package com.ale.mp.strategy.kefu;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.builder.kefu.NewsBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(WxConsts.KefuMsgType.NEWS)
public class NewsKefuMsgBuildStrategy implements KefuMsgBuildStrategy {
    @Override
    public WxMpKefuMessage build(String msgContent) {
        List<WxMpKefuMessage.WxArticle> wxArticles = JSON.parseArray(msgContent, WxMpKefuMessage.WxArticle.class);
        NewsBuilder newsBuilder = new NewsBuilder().articles(wxArticles);
        return newsBuilder.build();
    }
}
