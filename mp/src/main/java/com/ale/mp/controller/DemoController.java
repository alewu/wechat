package com.ale.mp.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class DemoController {
    private final WxMpService wxService;

    @GetMapping("/index")
    public String index() {
        String shortUrl = "";
        try {
            shortUrl = wxService.shortUrl("http://aa.qiaor.cn/h5/index.html?linkId=1304");
            log.info("shortUrl:{}", shortUrl);
            String normalUrl = wxService.shortUrl("https://developers.weixin.qq.com/doc/offiaccount/Account_Management/URL_Shortener.html");
            log.info("normalUrl:{}", normalUrl);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return shortUrl;
    }
}
