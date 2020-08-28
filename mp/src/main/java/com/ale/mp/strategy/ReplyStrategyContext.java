package com.ale.mp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author alewu
 * @date 2020/8/28
 */
@Component
public class ReplyStrategyContext {
    @Autowired
    private Map<String, ReplyStrategy> msgCategoryToReplyStrategy;

    public ReplyStrategy get(String category) {
        return msgCategoryToReplyStrategy.get(category);
    }
}
