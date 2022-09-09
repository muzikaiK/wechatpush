package cn.cvzhanshi.wechatpush.config;


import cn.cvzhanshi.wechatpush.entity.Weather;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Map;

/**
 * @author cVzhanshi
 * @create 2022-08-04 21:09
 */
public class Pusher {
    public static void main(String[] args) {
        push();
    }
    private static String appId = "wxb4e25534c6674313";
    private static String secret = "1dc3c2dd4fbf1fb6495c6c4afc45828c";

    public static void push(){
        //1，配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(appId);
        wxStorage.setSecret(secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                // .toUser("o4jup6Ew7U59oQbkBcbXVh1vxm8o")//kai
                 .toUser("o4jup6DiV9VttcSRMuRjmQ_G65XQ")//fang
                .templateId("8F3AOyECyJUbnV9TDVIvHtccbli8lyRw-vRMUa2GMBo")
                .build();
        //3,如果是正式版发送模版消息，这里需要配置你的信息
        Weather weather = WeatherUtils.getWeather();
        Map<String, String> map = CaiHongPiUtils.getEnsentence();
        templateMessage.addData(new WxMpTemplateData("riqi",weather.getDate() + "  "+ weather.getWeek(),"#00BFFF"));
        templateMessage.addData(new WxMpTemplateData("tianqi",weather.getText_now(),"#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("low",weather.getLow() + "","#FF6347"));
        templateMessage.addData(new WxMpTemplateData("temp",weather.getTemp() + "","#00FFFF"));
        templateMessage.addData(new WxMpTemplateData("high",weather.getHigh()+ "","#FF6347" ));
        templateMessage.addData(new WxMpTemplateData("windclass",weather.getWind_class()+ "","#42B857" ));
        templateMessage.addData(new WxMpTemplateData("winddir",weather.getWind_dir()+ "","#B95EA3" ));
        templateMessage.addData(new WxMpTemplateData("caihongpi",CaiHongPiUtils.getCaiHongPi(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("lianai",JiNianRiUtils.getLianAi()+"","#FF1493"));
        templateMessage.addData(new WxMpTemplateData("shengri1",JiNianRiUtils.getBirthday_Jo()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("shengri2",JiNianRiUtils.getBirthday_Hui()+"","#FFA500"));
        templateMessage.addData(new WxMpTemplateData("en",map.get("en") +"","#09091f"));
        templateMessage.addData(new WxMpTemplateData("zh",map.get("zh") +"","#09091f"));
        String beizhu = "凯❤芳1314";
        if(JiNianRiUtils.getLianAi() % 365 == 0){
            beizhu = "今天是恋爱" + (JiNianRiUtils.getLianAi() / 365) + "周年纪念日！";
        }
        if(JiNianRiUtils.getBirthday_Jo()  == 0){
            beizhu = "今天是臭凯生日，生日快乐呀！";
        }
        if(JiNianRiUtils.getBirthday_Hui()  == 0){
            beizhu = "今天是臭芳生日，生日快乐呀！";
        }
        templateMessage.addData(new WxMpTemplateData("beizhu",beizhu,"#FF0000"));
        try {
            System.out.println(templateMessage.toJson());
            System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }
}
