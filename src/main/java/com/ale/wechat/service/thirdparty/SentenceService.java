package com.ale.wechat.service.thirdparty;

import com.ale.wechat.bean.Sentence;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ale
 */
@Service
public class SentenceService {
    @Autowired
    private RestTemplate restTemplate;

    /***********HTTP GET method*************/
    public Sentence getSentence() {
        String url = "http://open.iciba.com/dsapi/";
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        return JSON.parseObject(results.getBody(), Sentence.class);
    }



}
