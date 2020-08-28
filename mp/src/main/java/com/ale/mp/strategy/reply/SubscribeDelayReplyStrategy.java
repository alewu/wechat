package com.ale.mp.strategy.reply;

import com.ale.mp.strategy.ReplyStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author alewu
 * @date 2020/8/28
 */
@Service("subscribeDelay")
@Slf4j
@AllArgsConstructor
public class SubscribeDelayReplyStrategy implements ReplyStrategy {

    @Override
    public void handle(String appId) {
        // 2 关注回复-延时发送
        // 2.1 关闭原设置的延时消息回复内容
    }
}
