package com.ale.mp;

import com.alibaba.fastjson.JSON;
import me.chanjar.weixin.mp.bean.kefu.WxMpKefuMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.util.xml.XStreamTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.List;

//@SpringBootTest
class WechatMpApplicationTests {

    @Test
    void contextLoads() {
        String responseMsg = "<xml>\n" +
                "  <ToUserName><![CDATA[o_cxDuBE2Bn9IvxSUsMUWXI6aG14]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[gh_57e091b030dc]]></FromUserName>\n" +
                "  <CreateTime><![CDATA[1591949387]]></CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[踩踩踩从<a href='www.baidu.com'>xx</a>]]></Content>\n" +
                "</xml> \n";
        WxMpXmlMessage wxMpXmlMessage = XStreamTransformer.fromXml(WxMpXmlMessage.class, responseMsg);
        System.out.println(wxMpXmlMessage.getMsgType());
        System.out.println(wxMpXmlMessage.getContent());

    }

    @Test
    public void test() {

        String aa = "<xml>\n" +
                "  <ToUserName><![CDATA[o_cxDuBE2Bn9IvxSUsMUWXI6aG14]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[gh_57e091b030dc]]></FromUserName>\n" +
                "  <CreateTime><![CDATA[1591962254]]></CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[<a href='http://sp.upuptec.cn/h5/index.html?linkId=1186'>平均分配</a>]]></Content>\n" +
                "</xml>\n";
        StopWatch sw = new StopWatch("WechatMpApplicationTests.test");
        sw.start();
        WxMpXmlMessage wxMpXmlMessage = XStreamTransformer.fromXml(WxMpXmlMessage.class, aa);
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(wxMpXmlMessage.getMsgType());

    }

    @Test
    public void tesXml() {
        String xml = "<xml>\n" +
                "  <ToUserName><![CDATA[o_cxxxsMUWXI6aG14]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[gh_xxx]]></FromUserName>\n" +
                "  <CreateTime><![CDATA[1591961648]]></CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[踩踩踩从<a href='www.baidu.com'>xx</a>]]></Content>\n" +
                "</xml> \n";
        WxMpXmlMessage wxMpXmlMessage = XStreamTransformer.fromXml(WxMpXmlMessage.class, xml);
        System.out.println(wxMpXmlMessage.getMsgType());
        WxMpXmlOutTextMessage wxMpXmlOutTextMessage = XStreamTransformer.fromXml(WxMpXmlOutTextMessage.class, xml);

        System.out.println(wxMpXmlOutTextMessage.getMsgType());

    }

    @Test
    public void tesXml1() {
        String xml = "<xml>\n" +
                "  <ToUserName><![CDATA[o_cxxxsMUWXI6aG14]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[gh_xxx]]></FromUserName>\n" +
                "  <CreateTime><![CDATA[1591961648]]></CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[踩踩踩从<a href='www.baidu.com'>xx</a>]]></Content>\n" +
                "</xml> \n";

        WxMpXmlOutMessage wxMpXmlOutMessage = XStreamTransformer.fromXml(WxMpXmlOutMessage.class, xml);

        System.out.println(wxMpXmlOutMessage.getMsgType());

    }

    @Test
    void test1() {
        String article = "[{\"title\": \"aaa\",\"description\": \"aa\",\"url\": \"xx\",\"picurl\": \"http://134.175.245.70:808/wxc3cb5723a8c7b4f8/image/20200821/15979959228725918.jpg\"}]";
        List<WxMpKefuMessage.WxArticle> wxArticles = JSON.parseArray(article, WxMpKefuMessage.WxArticle.class);
        WxMpKefuMessage.WxArticle wxArticle = wxArticles.get(0);
        System.out.println(wxArticle.getPicUrl());
    }

}
