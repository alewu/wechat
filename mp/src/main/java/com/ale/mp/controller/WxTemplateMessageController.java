package com.ale.mp.controller;

import com.ale.mp.bean.CityWeather;
import com.ale.mp.bean.DailyWeather;
import com.ale.mp.bean.Sentence;
import com.ale.mp.bean.WeatherResponse;
import com.ale.mp.service.thirdparty.SentenceService;
import com.ale.mp.service.thirdparty.WeatherService;
import com.ale.mp.service.internal.WxMpTemplateMessageSendService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ale
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/wx/message/{appid}")
public class WxTemplateMessageController {
    private final WxMpTemplateMessageSendService sendService;
    private final SentenceService sentenceService;
    private final WeatherService weatherService;
    /**
     * 模板消息字体颜色；绿色
     */
    private static final String TEMPLATE_FRONT_COLOR_LIME_GREEN = "#32CD32";
    /**
     * 模板消息字体颜色；蓝色
     */
    private static final String TEMPLATE_FRONT_COLOR_MEDIUM_BLUE = "#7B68EE";
    /**
     * 用户
     */
    //    private static String[] users = {"objx5v1dRhfDIpXmJWfF41z27Gy8", "objx5v6qPohfeILITPXuFz5bifa4"};

    /**
     * 每日一句模板id
     */
    private static final String ONE_SENTENCE_DAILY_TEMPLATE_ID = "RfQ25xZKRP9tpGa5WmoZ5NHNc-RguuPpx97bi-jHQpc";
    /**
     * 天气模板id
     */
    public static final String WEATHER_TEMPLATE_ID = "GIWStZBWQEopQYWii-QZWHuYhmAGUs-ZLUSuWk88GVU";

    @PostMapping("/sendDailySentence")
    public String sendTemplateMessage(@RequestBody List<String> users) {
        for (String user : users) {
            sendOneSentenceDaily(user);
        }
        return "ok";
    }

    private void sendOneSentenceDaily(String user) {
        Sentence sentence = sentenceService.getSentence();
        List<WxMpTemplateData> templateDataList = getSentenceWxMpTemplateData(sentence);
        sendService.sendTemplateMsg(user, ONE_SENTENCE_DAILY_TEMPLATE_ID, templateDataList);
    }

    private List<WxMpTemplateData> getSentenceWxMpTemplateData(Sentence sentence) {
        List<WxMpTemplateData> templateDataList = new ArrayList<>();
        WxMpTemplateData content = new WxMpTemplateData("content", sentence.getContent(),
                                                        TEMPLATE_FRONT_COLOR_MEDIUM_BLUE);
        WxMpTemplateData note = new WxMpTemplateData("note", sentence.getNote(), TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData translation = new WxMpTemplateData("translation", sentence.getTranslation(),
                                                            TEMPLATE_FRONT_COLOR_LIME_GREEN);
        templateDataList.add(content);
        templateDataList.add(note);
        templateDataList.add(translation);
        return templateDataList;
    }

    @PostMapping("/sendWeather")
    public String sendWeather(@RequestBody List<String> users) throws IOException {
        for (String user : users) {
            WeatherResponse response = weatherService.getWeather();
            // {{city.DATA}} {{day.DATA}} {{wea.DATA}} {{tem1.DATA}} {{air_tips.DATA}}
            List<WxMpTemplateData> templateDataList = getWeatherWxMpTemplateData(response);
            sendService.sendTemplateMsg(user, WEATHER_TEMPLATE_ID, templateDataList);
        }
        return "ok";
    }

    private List<WxMpTemplateData> getWeatherWxMpTemplateData(WeatherResponse response) {
        CityWeather cityWeather = response.getData();
        DailyWeather dailyWeather = cityWeather.getForecast().get(0);
        WxMpTemplateData city = new WxMpTemplateData("city", "城市：" + cityWeather.getCity(),
                                                     TEMPLATE_FRONT_COLOR_MEDIUM_BLUE);
        WxMpTemplateData day = new WxMpTemplateData("day", "日期：" + dailyWeather.getDate(),
                                                    TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData wea = new WxMpTemplateData("wea", "天气：" + dailyWeather.getType(),
                                                    TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData tem1 = new WxMpTemplateData("tem1", "温度：" + cityWeather.getWendu(),
                                                     TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData airTips = new WxMpTemplateData("air_tips", "温馨提示：" +cityWeather.getGanmao(),
                                                        TEMPLATE_FRONT_COLOR_LIME_GREEN);
        List<WxMpTemplateData> templateDataList = new ArrayList<>();
        templateDataList.add(city);
        templateDataList.add(day);
        templateDataList.add(wea);
        templateDataList.add(tem1);
        templateDataList.add(airTips);

        return templateDataList;
    }

}
