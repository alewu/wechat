package com.ale.mp.controller;

import com.ale.mp.bean.KeFuMessage;
import com.ale.mp.strategy.kefu.KefuMsgStrategyContext;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class DemoController {
    private final WxMpService wxService;
    @Autowired
    private KefuMsgStrategyContext messageStrategyContext;

    @GetMapping("/index")
    public String index() {
        String shortUrl = "";
        try {
            shortUrl = wxService.shortUrl("http://aa.qiaor.cn/h5/index.html?linkId=1304");
            log.info("shortUrl:{}", shortUrl);
            String normalUrl = wxService.shortUrl("https://developers.weixin.qq" +
                                                          ".com/doc/offiaccount/Account_Management/URL_Shortener.html");
            log.info("normalUrl:{}", normalUrl);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return shortUrl;
    }

    /**
     * @author alewu
     * @date 2020/8/24 15:24
     */
    @PostMapping("/msgType")
    public ResponseEntity<WxMpKefuMessage> msg(@RequestBody KeFuMessage msg) {
//        if (Objects.equals(msgType, WxConsts.KefuMsgType.TEXT)) {
//
//        } else if (Objects.equals(msgType, WxConsts.KefuMsgType.IMAGE)) {
//
//        } else if (Objects.equals(msgType, WxConsts.KefuMsgType.VIDEO)) {
//
//        } else if (Objects.equals(msgType, WxConsts.KefuMsgType.VOICE)) {
//
//        }
        WxMpKefuMessage kefuMessage = messageStrategyContext.getStrategy(msg.getMsgType()).build(msg.getMsgContent());
        return ResponseEntity.ok(kefuMessage);
    }


}
