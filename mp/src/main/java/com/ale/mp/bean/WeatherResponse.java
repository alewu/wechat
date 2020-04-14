package com.ale.mp.bean;

import lombok.Data;

/**
 * @author ale
 */
@Data
public class WeatherResponse {
    /**
     * data : {"yesterday":{"date":"2日星期一","high":"高温 19℃","fx":"无持续风向","low":"低温 7℃","fl":"<![CDATA[<3级]]>",
     * "type":"多云"},"city":"河源","forecast":[{"date":"3日星期二","high":"高温 19℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃",
     * "fengxiang":"无持续风向","type":"晴"},{"date":"4日星期三","high":"高温 20℃","fengli":"<![CDATA[<3级]]>","low":"低温 9℃",
     * "fengxiang":"无持续风向","type":"多云"},{"date":"5日星期四","high":"高温 13℃","fengli":"<![CDATA[<3级]]>","low":"低温 10℃",
     * "fengxiang":"无持续风向","type":"阴"},{"date":"6日星期五","high":"高温 17℃","fengli":"<![CDATA[<3级]]>","low":"低温 8℃",
     * "fengxiang":"无持续风向","type":"晴"},{"date":"7日星期六","high":"高温 18℃","fengli":"<![CDATA[<3级]]>","low":"低温 7℃",
     * "fengxiang":"无持续风向","type":"晴"}],"ganmao":"天凉，昼夜温差较大，较易发生感冒，请适当增减衣服，体质较弱的朋友请注意适当防护。","wendu":"14"}
     */
    private CityWeather data;

    private int status;

    private String desc;

}
