package com.bobby.peng.learning.java.basic.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bobby.peng.learning.java.exams.ClassA;
import com.bobby.peng.learning.java.exams.ClassB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by peng2035 on 2017/8/1.
 */
public class JsonFieldCompareUtils {

    public static Map<String,Integer> findDiff(String json1,String json2) {
        JSONObject jsonObject1 = JSON.parseObject(json1);
        JSONObject jsonObject2 = JSON.parseObject(json2);

        Map<String,Integer> result = new HashMap<>();

        for(Map.Entry<String,Object> entry : jsonObject1.entrySet()) {
            if(jsonObject2.get(entry.getKey()) == null) {
                result.put(entry.getKey(),1);
            }
        }

        for(Map.Entry<String,Object> entry : jsonObject2.entrySet()) {
            if(jsonObject1.get(entry.getKey()) == null) {
                result.put(entry.getKey(),2);
            }
        }

        return result;
    }


    public static void main(String[] args) {
//        String json1 = "{\"IsAgree\":\"1\",\"bankAccount\":\"6230299800005065\",\"bindBank\":\"HKBCHINA\",\"bindCardNo\":\"6230299800005065\",\"bindCity\":\"武汉市\",\"bindPhone\":\"15656565656\",\"bindProvince\":\"湖北省\",\"borrowerCertiNo\":\"420101198001012684\",\"borrowerCertiType\":\"1\",\"borrowerName\":\"众安静\",\"borrowerPhone\":\"15656565656\",\"email\":\"I@163.com\",\"entryMonth\":0,\"fundFirstAmout\":\"07\",\"fundFiveAmout\":\"07\",\"fundFourAmout\":\"02\",\"fundSecondAmout\":\"07\",\"fundSixAmout\":\"07\",\"ipAddress\":\"211.161.165.212\",\"linkmen\":[{\"relationship\":\"01\",\"relativeName\":\"测试\",\"relativePhone\":\"16985808589\"}],\"liveAddress\":\"湖北省武汉市现在居住地址580号\",\"macNo\":\"8ADBFA076FDCEF15D599C5DF8A9B679DE4C464396857F13F\",\"monthlyPay\":\"1\",\"positionType\":\"1\",\"sex\":\"F\",\"socialFirstAmout\":\"2013-09|-|28|江岸区\",\"socialFiveAmout\":\"||01|\",\"socialFourAmout\":\"||01|\",\"socialSecondAmout\":\"2013-07|2013-08|28|江岸区\",\"socialSixAmout\":\"||01|\",\"socialThreeAmout\":\"||01|\",\"unitsAddress\":\"湖北省武汉市单位地址测试580号\",\"workCompany\":\"测试\",\"workTelphone\":\"36985258\"}";
        String json2 = "{\"sex\":\"F\",\"phone\":\"13164174678\",\"socialSixAmout\":\"||01|\",\"socialFiveAmout\":\"||01|\",\"linkmen\":[{\"relationship\":\"父母\",\"relativeName\":\"王霞\",\"relativePhone\":\"15927627606\"}],\"socialSecondAmout\":\"2017-04|2017-04|11|武汉地铁运营有限公司\",\"borrowerCertiType\":\"1\",\"liveAddress\":\"湖北省武汉市新洲区邾城街古城大道黄茂社区黄茂里6号\",\"bindCity\":\"武汉市\",\"borrowerPhone\":\"13164174678\",\"fundBalance\":\"11282.68\",\"fundThreeAmout\":\"08\",\"positionType\":\"管理\",\"socialBalance\":\"5869.36\",\"bindBank\":\"HKBCHINA\",\"fundFourAmout\":\"08\",\"fundFiveAmout\":\"08\",\"socialFourAmout\":\"2017-02|2017-02|11|武汉地铁运营有限公司\",\"IsAgree\":\"1\",\"ipAddress\":\"58.49.77.70\",\"entryMonth\":\"24\",\"bindPhone\":\"13164174678\",\"fundStaus\":\"1\",\"bindProvince\":\"湖北省\",\"bindCardNo\":\"6230299803366944\",\"borrowerCertiNo\":\"420117199405300020\",\"fundSixAmout\":\"08\",\"fundSecondAmout\":\"08\",\"socialThreeAmout\":\"2017-03|2017-03|11|武汉地铁运营有限公司\",\"units\":\"武汉地铁运营有限公司\",\"monthlyPay\":\"5600\",\"socialFirstAmout\":\"2017-05|2017-05|11|武汉地铁运营有限公司\",\"unitsAddress\":\"湖北省武汉市硚口区武汉地铁一号线利济北路轻轨站\",\"email\":\"huangc8353@whrt.gov.cn\",\"fundFirstAmout\":\"08\",\"MacCode\":\"BAA6FA73CDDD4BD18AAE1507E44EFFDD\",\"borrowerName\":\"黄岑\",\"bankAccount\":\"6230299803366944\"}";

        String json1 = "{\"IsAgree\":\"1\",\"bankAccount\":\"6230299800000975\",\"bindBank\":\"HKBCHINA\",\"bindCardNo\":\"6230299800000975\",\"bindCity\":\"武汉市\",\"bindPhone\":\"13995520031\",\"bindProvince\":\"湖北省\",\"borrowerCertiNo\":\"112011165412212438\",\"borrowerCertiType\":\"1\",\"borrowerName\":\"韦小宝\",\"borrowerPhone\":\"13758127384\",\"email\":\"105788@qq.com\",\"entryMonth\":0,\"fundBalance\":\"19962.28\",\"fundFirstAmout\":\"07\",\"fundFiveAmout\":\"07\",\"fundFourAmout\":\"02\",\"fundSecondAmout\":\"07\",\"fundSixAmout\":\"07\",\"fundStaus\":\"1\",\"fundThreeAmout\":\"01\",\"ipAddress\":\"171.113.71.89\",\"linkmen\":[{\"relationship\":\"01\",\"relativeName\":\"王\",\"relativePhone\":\"13800138000\"}],\"liveAddress\":\"湖北省武汉市汉口银行1415\",\"locationGps\":\"\",\"macNo\":\"19EE76BC1DB6C36904A6193F33561408E4C464396857F13F\",\"monthlyPay\":\"10000\",\"phone\":\"13995520031\",\"positionType\":\"1\",\"sex\":\"M\",\"socialBalance\":\"1680.00\",\"socialFirstAmout\":\"||01|\",\"socialFiveAmout\":\"||01|\",\"socialFourAmout\":\"||01|\",\"socialSecondAmout\":\"||01|\",\"socialSixAmout\":\"||01|\",\"socialThreeAmout\":\"||01|\",\"units\":\"中国船舶重工集团公司第七一七研究所\",\"unitsAddress\":\"湖北省武汉市汉口银行1415\",\"workCompany\":\"汉口银行\",\"workTelphone\":\"12345678\"}";
        Map<String,Integer> result = findDiff(json1,json2);
        System.out.println(result);
    }
}
