package com.ale.mp.service.thirdparty;

import com.ale.mp.bean.WeatherResponse;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

/**
 * @author ale
 */
@Service
@Slf4j
public class WeatherService {
    @Autowired
    private RestTemplate restTemplate;

    /***********HTTP GET method*************/
    public WeatherResponse getWeather() {
        String url = "http://wthrcdn.etouch.cn/weather_mini?city=河源";
        //把数据和头部信息封装
        HttpHeaders headers = getHttpHeaders();
        HttpEntity<String> formEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class);
        String jsonString = getJsonStringFromGzip(response);
        return JSON.parseObject(jsonString, WeatherResponse.class);
    }

    private String getJsonStringFromGzip(ResponseEntity<String> response) {
        String transferStr = "";
        try (InputStream in =
                     new ByteArrayInputStream(Objects.requireNonNull(response.getBody()).getBytes(StandardCharsets.ISO_8859_1.name()));
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            GZIPInputStream gunzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            transferStr = out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transferStr;
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, "text/plain;charset=ISO-8859-1");
        headers.add(HttpHeaders.ACCEPT_ENCODING, "gzip");
        headers.add(HttpHeaders.CONTENT_ENCODING, StandardCharsets.UTF_8.name());
        return headers;
    }

}
