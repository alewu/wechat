package com.ale.mp.strategy.reply;

import com.ale.mp.strategy.ReplyStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author alewu
 * @date 2020/8/28
 */
@Service("subscribeImmediately")
@Slf4j
public class SubscribeImmediatelyReplyStrategy implements ReplyStrategy {

    @Override
    public void handle(String appId) {
        // 1. 关注回复-立即发送
        // 1.1 删除原设置的关注回复内容

    }
}
