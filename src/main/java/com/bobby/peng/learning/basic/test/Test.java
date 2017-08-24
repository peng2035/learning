package com.bobby.peng.learning.basic.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng2035 on 2017/7/25.
 */
public class Test {
    public static void main(String[] args) {

        String value = "{\"certName\":\"李姣姣\",\"certType\":1,\"applyNo\":\"45012017072549014528\",\"partnerNo\":\"2323001\",\"thirdUserNo\":\"10000001521\",\"otherInfo\":\"{\\\"IsAgree\\\":\\\"1\\\",\\\"bankAccount\\\":\\\"6230299800001056\\\",\\\"bindBank\\\":\\\"HKBCHINA\\\",\\\"bindCardNo\\\":\\\"6230299800001056\\\",\\\"bindCity\\\":\\\"武汉市\\\",\\\"bindPhone\\\":\\\"13297988502\\\",\\\"bindProvince\\\":\\\"湖北省\\\",\\\"borrowerCertiNo\\\":\\\"513901198805123046\\\",\\\"borrowerCertiType\\\":\\\"1\\\",\\\"borrowerName\\\":\\\"李姣姣\\\",\\\"borrowerPhone\\\":\\\"13297988502\\\",\\\"email\\\":\\\"456231@qq.com\\\",\\\"entryMonth\\\":0,\\\"fundFirstAmout\\\":\\\"07\\\",\\\"fundFiveAmout\\\":\\\"07\\\",\\\"fundFourAmout\\\":\\\"02\\\",\\\"fundSecondAmout\\\":\\\"07\\\",\\\"fundSixAmout\\\":\\\"07\\\",\\\"ipAddress\\\":\\\"211.161.165.212\\\",\\\"linkmen\\\":[{\\\"relationship\\\":\\\"03\\\",\\\"relativeName\\\":\\\"看看\\\",\\\"relativePhone\\\":\\\"15999966665\\\"}],\\\"liveAddress\\\":\\\"湖北省武汉市金融港当代1-2-301\\\",\\\"macNo\\\":\\\"883F99234BDD40F36C6DB6C99446DA92E4C464396857F13F\\\",\\\"monthlyPay\\\":\\\"8000\\\",\\\"positionType\\\":\\\"8\\\",\\\"sex\\\":\\\"F\\\",\\\"socialFirstAmout\\\":\\\"2013-09|-|28|江岸区\\\",\\\"socialFiveAmout\\\":\\\"||01|\\\",\\\"socialFourAmout\\\":\\\"||01|\\\",\\\"socialSecondAmout\\\":\\\"2013-07|2013-08|28|江岸区\\\",\\\"socialSixAmout\\\":\\\"||01|\\\",\\\"socialThreeAmout\\\":\\\"||01|\\\",\\\"unitsAddress\\\":\\\"湖北省武汉市高新大道22号米粒\\\",\\\"workCompany\\\":\\\"米粒有限公司\\\",\\\"workTelphone\\\":\\\"85645555\\\"}\",\"applyDate\":1500949200000,\"phoneNo\":\"13297988502\",\"traceId\":\"BMApMHfgYPySoZIPDZzngFajZRyObjYP\",\"certNo\":\"513901198805123046\",\"applyType\":1,\"partnerProductNo\":\"2323002\"}";

        JSONObject jsonObject = JSON.parseObject(value);

        for(Map.Entry<String,Object> entry : jsonObject.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue().toString());
        }

    }
}
