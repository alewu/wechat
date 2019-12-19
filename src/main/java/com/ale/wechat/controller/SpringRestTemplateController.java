package com.ale.wechat.controller;

import com.ale.wechat.service.thirdparty.SentenceService;
import com.ale.wechat.service.thirdparty.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SpringRestTemplateController {
    @Autowired
    private SentenceService sentenceService;
    @Autowired
    private WeatherService weatherService;

    /***********HTTP GET method*************/
    @GetMapping("/testGetApi")
    public String getJson() {
        return String.valueOf(sentenceService.getSentence());
    }

    /***********HTTP GET method*************/
    @GetMapping("/testGetWeather")
    public String getWeather() throws IOException {
        return String.valueOf(weatherService.getWeather());
    }


}
