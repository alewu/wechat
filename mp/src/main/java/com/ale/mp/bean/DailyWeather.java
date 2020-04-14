package com.ale.mp.bean;

import lombok.Data;

@Data
public class DailyWeather {
    /**
     * date : 3日星期二
     * high : 高温 19℃
     * fengli : <![CDATA[<3级]]>
     * low : 低温 8℃
     * fengxiang : 无持续风向
     * type : 晴
     */

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}