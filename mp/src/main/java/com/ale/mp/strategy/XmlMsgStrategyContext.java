package com.ale.mp.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
  *
  * @author alewu
  * @date 2020/8/26
  */
@Component
public class XmlMsgStrategyContext {
    @Autowired
    private Map<String, XmlMsgBuildStrategy> map;

    public XmlMsgBuildStrategy getStrategy(String msgType) {
        return map.get(msgType);
    }
}
