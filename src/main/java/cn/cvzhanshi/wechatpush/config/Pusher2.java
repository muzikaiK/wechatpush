package cn.cvzhanshi.wechatpush.config;


import cn.cvzhanshi.wechatpush.entity.TouTiaoNews;
import cn.cvzhanshi.wechatpush.entity.Weather;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.http.client.utils.HttpClientUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cVzhanshi
 * @create 2022-08-04 21:09
 */
public class Pusher2 {

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
                .toUser("o4jup6Ew7U59oQbkBcbXVh1vxm8o")//o4jup6DiV9VttcSRMuRjmQ_G65XQ
                .templateId("asEnMLrSr0B-MLFezbzrgoCprUy5a7HK_eMRMTrYNfM")
                .templateId("ZDIfJGbRQ17_AKB1Fhw0ZmRtktrfrTcX7UADiibbrKg")
                .build();

        TouTiaoNews touTiaoNews = XinWenUtils.getTouTiaoNews();
        List<TouTiaoNews.TouTiao> newslist = touTiaoNews.getNewslist();
        if (false) {
            return;
        }
        for (int i = 0; i < newslist.size(); i++) {
            templateMessage.addData(new WxMpTemplateData("n"+(i+1),newslist.get(i).getTitle()));
        }

        templateMessage.addData(new WxMpTemplateData("caihongpi",CaiHongPiUtils.getCaiHongPi(),"#FF69B4"));
        templateMessage.addData(new WxMpTemplateData("riqi",new SimpleDateFormat("yyyy年MM月dd日").format(new Date()) + "  星期"+ getWeekDay(),"#00BFFF"));
        try {
            String accessToken = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxb4e25534c6674313&secret=1dc3c2dd4fbf1fb6495c6c4afc45828c").execute().body();
            JSONObject token = JSONObject.parseObject(accessToken);
            String access_token = token.getString("access_token");
            String users = HttpRequest.get("https://api.weixin.qq.com/cgi-bin/user/get?access_token="+access_token).execute().body();
            JSONObject userObj = JSONObject.parseObject(users);
            JSONObject data = userObj.getJSONObject("data");
            JSONArray openids = data.getJSONArray("openid");
            for (int i = 0; i < openids.size()-2; i++) {
                String user = openids.getString(i);
                templateMessage.setToUser(user);
                System.out.println(wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage));
            }
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int getWeekDay() {
        Calendar now = Calendar.getInstance();
        boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        if(isFirstSunday){
            weekDay = weekDay - 1;
            if(weekDay == 0){
                weekDay = 7;
            }
        }
        return weekDay;
    }

}
