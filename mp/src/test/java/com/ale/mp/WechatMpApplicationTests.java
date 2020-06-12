package com.ale.mp;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import me.chanjar.weixin.mp.util.xml.XStreamTransformer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void test(){

        String aa = "<xml>\n" +
                "  <ToUserName><![CDATA[o_cxDuBE2Bn9IvxSUsMUWXI6aG14]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[gh_57e091b030dc]]></FromUserName>\n" +
                "  <CreateTime><![CDATA[1591962254]]></CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[<a href='http://sp.upuptec.cn/h5/index.html?linkId=1186'>平均分配</a>]]></Content>\n" +
                "</xml>\n";
        WxMpXmlMessage wxMpXmlMessage = XStreamTransformer.fromXml(WxMpXmlMessage.class, aa);
        System.out.println(wxMpXmlMessage.getMsgType());

    }

    @Test
    public void tesXml(){
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

}
