package com.ale.mp.handler.out;

import me.chanjar.weixin.common.api.WxConsts;
import org.springframework.stereotype.Component;
/**
  *  
  * @author alewu
  * @date 2020/8/31
  */
@Component(WxConsts.KefuMsgType.TEXT+"handler")
public class TextKefuMsgHandler extends Handler {

    @Override
    public void handleMessage(int type) {
        
    }
}
