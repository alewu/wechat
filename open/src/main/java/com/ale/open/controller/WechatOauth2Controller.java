package com.ale.open.controller;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.open.api.WxOpenComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class WechatOauth2Controller {
    @Autowired
    private WxOpenComponentService wxOpenComponentService;

    public void oauth(String appId, String code) throws WxErrorException {
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxOpenComponentService.oauth2getAccessToken("", "");
        wxMpOAuth2AccessToken.getOpenId();
    }
}
