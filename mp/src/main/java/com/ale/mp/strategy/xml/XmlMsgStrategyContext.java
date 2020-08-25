package com.ale.mp.strategy.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class XmlMsgStrategyContext {
    @Autowired
    private Map<String, XmlMsgBuildStrategy> map;

    public XmlMsgBuildStrategy getStrategy(String msgType) {
        return map.get(msgType);
    }
}
