package com.ale.mp.strategy.reply;


import com.ale.mp.strategy.ReplyStrategy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author alewu
 * @date 2020/8/28
 */
@Service("keyword")
@Slf4j
@AllArgsConstructor
public class KeywordReplyStrategy implements ReplyStrategy {

    @Override
    public void handle(String appId) {
        // 3.关键词回复

    }

}
