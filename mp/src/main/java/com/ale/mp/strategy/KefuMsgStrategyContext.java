package com.ale.mp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class KefuMsgStrategyContext {
    @Autowired
    private Map<String, KefuMsgBuildStrategy> map;

    public KefuMsgBuildStrategy getStrategy(String msgType) {
        return map.get(msgType);
    }
}
