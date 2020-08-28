package com.ale.mp.strategy.reply;


import com.ale.mp.strategy.ReplyStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author alewu
 * @date 2020/8/28
 */
@Service("default")
@Slf4j
@AllArgsConstructor
public class DefaultReplyStrategy implements ReplyStrategy {

    @Override
    public void handle(String appId) {
        // 4. 默认回复
        // 4.1 将原有默认回复的内容删除

    }
}
