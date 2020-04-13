package com.ale.wechat.service.internal;

import com.ale.wechat.bean.CityWeather;
import com.ale.wechat.bean.DailyWeather;
import com.ale.wechat.bean.Sentence;
import com.ale.wechat.bean.WeatherResponse;
import com.ale.wechat.service.thirdparty.SentenceService;
import com.ale.wechat.service.thirdparty.WeatherService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ale
 */
@Service
public class QuartzService {
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
    private static String[] users = {"objx5v1dRhfDIpXmJWfF41z27Gy8", "objx5v6qPohfeILITPXuFz5bifa4"};

    /**
     * 每日一句模板id
     */
    private static final String ONE_SENTENCE_DAILY_TEMPLATE_ID = "RfQ25xZKRP9tpGa5WmoZ5NHNc-RguuPpx97bi-jHQpc";
    /**
     * 天气模板id
     */
    public static final String WEATHER_TEMPLATE_ID = "GIWStZBWQEopQYWii-QZWHuYhmAGUs-ZLUSuWk88GVU";
    /**
     * COMPOSE
     */
    public static final String COMPOSE = "f07nuYepk8h9La5fRkUUSAjCL9GT41PZZ9XfiLJGgyE";

    @Autowired
    private SentenceService sentenceService;
    @Autowired
    private WxMpTemplateMessageSendService sendService;
    @Autowired
    private WeatherService weatherService;

    @Scheduled(cron = "0/3000 * * * * ?")
    public void runFirst() {
        compose(users[0]);
    }

    private void compose(String user) {
        Sentence sentence = sentenceService.getSentence();
        WeatherResponse response = weatherService.getWeather();
        List<WxMpTemplateData> composeWxMpTemplateData = getComposeWxMpTemplateData(sentence, response);
        String msg = sendService.sendTemplateMsg(user, COMPOSE, composeWxMpTemplateData);

    }

    private void sendOneSentenceDaily(String user) {
        Sentence sentence = sentenceService.getSentence();
        List<WxMpTemplateData> templateDataList = getSentenceWxMpTemplateData(sentence);
        String msg = sendService.sendTemplateMsg(user, ONE_SENTENCE_DAILY_TEMPLATE_ID, templateDataList);
    }

    private List<WxMpTemplateData> getComposeWxMpTemplateData(Sentence sentence, WeatherResponse response) {
        List<WxMpTemplateData> templateDataList = new ArrayList<>();
        WxMpTemplateData translation = new WxMpTemplateData("translation", sentence.getNote(),
                                                            TEMPLATE_FRONT_COLOR_MEDIUM_BLUE);
        WxMpTemplateData content = new WxMpTemplateData("content", "宝宝，以下是给你的天气预报哦！",
                                                    TEMPLATE_FRONT_COLOR_LIME_GREEN);
        CityWeather cityWeather = response.getData();
        DailyWeather dailyWeather = cityWeather.getForecast().get(0);

        WxMpTemplateData city = new WxMpTemplateData("city", "城市：" + cityWeather.getCity(),
                                                     TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData day = new WxMpTemplateData("day", "日期：" + dailyWeather.getDate(),
                                                    TEMPLATE_FRONT_COLOR_LIME_GREEN);
        String weather = String.format("今天天气%s，温度%s度。", dailyWeather.getType(), cityWeather.getWendu());
        WxMpTemplateData wea = new WxMpTemplateData("wea", weather,
                                                    TEMPLATE_FRONT_COLOR_LIME_GREEN);
        WxMpTemplateData airTips = new WxMpTemplateData("air_tips", "温馨提示：" + cityWeather.getGanmao(),
                                                        TEMPLATE_FRONT_COLOR_LIME_GREEN);
        templateDataList.add(content);
        templateDataList.add(translation);
        templateDataList.add(city);
        templateDataList.add(day);
        templateDataList.add(wea);
        templateDataList.add(airTips);

        return templateDataList;
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


    public void sendDailyWeather(String user) {
        WeatherResponse response = weatherService.getWeather();
        // {{city.DATA}} {{day.DATA}} {{wea.DATA}} {{tem1.DATA}} {{air_tips.DATA}}
        List<WxMpTemplateData> templateDataList = getWeatherWxMpTemplateData(response);
        sendService.sendTemplateMsg(user, WEATHER_TEMPLATE_ID, templateDataList);
    }

    private List<WxMpTemplateData> getWeatherWxMpTemplateData(WeatherResponse response) {
        List<WxMpTemplateData> templateDataList = new ArrayList<>();
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
        WxMpTemplateData airTips = new WxMpTemplateData("air_tips", "温馨提示：" + cityWeather.getGanmao(),
                                                        TEMPLATE_FRONT_COLOR_LIME_GREEN);
        templateDataList.add(city);
        templateDataList.add(day);
        templateDataList.add(wea);
        templateDataList.add(tem1);
        templateDataList.add(airTips);
        return templateDataList;
    }
}
