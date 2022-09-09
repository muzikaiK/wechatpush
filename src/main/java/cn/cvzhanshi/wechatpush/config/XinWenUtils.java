package cn.cvzhanshi.wechatpush.config;

import cn.cvzhanshi.wechatpush.entity.TouTiaoNews;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author lk
 * @date 2022/9/1 下午 06:35
 */
public class XinWenUtils {
    private static String key = "65cb05fe8e040b2daa9c60c8a9548766";
    private static String url = "http://api.tianapi.com/topnews/index?key=";
    public static TouTiaoNews getTouTiaoNews(){
        //String body = HttpRequest.get(url + key).execute().body();
        String body = "{\"code\":200,\"msg\":\"success\",\"newslist\":[{\"id\":\"9300c1519110f8d90aca3137a632f64b\",\"ctime\":\"2022-09-01 16:07:31\",\"title\":\"（国际）一油轮在埃及苏伊士运河搁浅后脱困\",\"description\":\"埃及苏伊士运河管理局9月1日说，一艘油轮8月31日晚在苏伊士运河搁浅，随后在拖船协助下起浮脱浅，运河航道目前已恢复正常。\",\"picUrl\":\"\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138345605386109447\\/\",\"source\":\"新华社\"},{\"id\":\"20196e8ec21cffdd6e54ec68e07d44d1\",\"ctime\":\"2022-09-01 16:15:01\",\"title\":\"威海市环翠区13件非遗作品获省级金奖\",\"description\":\"齐鲁网·闪电新闻9月1日讯日前，2022第十四届中国（山东）工艺美术博览会暨首届“山东手造”精品展在济南圆满落幕。博览会参展企业300余家，参展工艺美术从业者近千人，参观客流量近5万人次，意向成交额1000余万元。\",\"picUrl\":\"http:\\/\\/p26.toutiaoimg.com\\/img\\/tos-cn-i-tjoges91tu\\/TGAuhWR72oBZRl~tplv-tt-cs0:798:519.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138348606372872719\\/\",\"source\":\"闪电新闻\"},{\"id\":\"bb4ff6536af82d6fea42b7dd0ac102f8\",\"ctime\":\"2022-09-01 16:22:31\",\"title\":\"银保监会：完善偿付能力监管标准 增强保险业服务能力\",\"description\":\"记者从银保监会获悉，为更好引导保险业服务实体经济，银保监会将持续完善偿付能力监管标准，在科学有效防控风险基础上，不断增强保险业服务经济社会大局的能力。\",\"picUrl\":\"http:\\/\\/p6.toutiaoimg.com\\/img\\/tos-cn-i-tjoges91tu\\/Snbotc66RPZVk3~tplv-tt-cs0:3000:2000.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138350694318211588\\/\",\"source\":\"新华社\"},{\"id\":\"21ba7ca88da7f1bc1931d32bd42251df\",\"ctime\":\"2022-09-01 16:30:01\",\"title\":\"观念能力作风建设年 | 郑州市公安局登封市局市局：落实 “五小”工程，爱警从“心”出发\",\"description\":\"为纵深推进夏季治安打击整治“百日行动”，迎接党的二十大胜利召开，登封市公安局立足工作实际，严格遵照公安部“要注重爱警暖警，科学安排勤务和警力，保持队伍旺盛的战斗力”的指示精神，牢固树立郑州市局党委“实战第一、基层第一、群众第一、民警第一”的理念，以“五小工程”为抓手，切实把公安部\",\"picUrl\":\"http:\\/\\/p9.toutiaoimg.com\\/img\\/tos-cn-i-qvj2lq49k0\\/e2bf3b9eabd74727bfb894dac8cad288~tplv-tt-cs0:1080:810.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138341804323209732\\/\",\"source\":\"郑警发布\"},{\"id\":\"87e5be3ffcf76c392eb8a35d89d5d920\",\"ctime\":\"2022-09-01 16:37:31\",\"title\":\"开学啦，这些丰富多彩的体育课为你准备好啦\",\"description\":\"今天是9月1日，全国中小学生开学的大日子休息了一个暑假，你最想念学校的什么呢？\",\"picUrl\":\"http:\\/\\/p26.toutiaoimg.com\\/img\\/tos-cn-i-qvj2lq49k0\\/cb5f0e6baf654abd91d94d103b538d06~tplv-tt-cs0:1000:667.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138351240584430111\\/\",\"source\":\"新华社\"},{\"id\":\"87ba000a2f20515b628f8483f1586889\",\"ctime\":\"2022-09-01 16:45:01\",\"title\":\"2个老师5个娃——大山里的“微小学”开学见闻\",\"description\":\"9月1日，随着升旗仪式的举行，大山深处的福建永泰县白云乡凤际小学迎来了新学年的开学第一天。与众不同的是，这所学校只有5名学生和2名老师。\",\"picUrl\":\"http:\\/\\/p3.toutiaoimg.com\\/img\\/tos-cn-i-tjoges91tu\\/TGAw5QQ9PCxH9q~tplv-tt-cs0:2640:1978.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138350124257772073\\/\",\"source\":\"新华社\"},{\"id\":\"7065ab869ce057e815bc8b59aa00c5ec\",\"ctime\":\"2022-09-01 16:52:31\",\"title\":\"空天报国 领航未来——北航喜迎6650名研究生新生\",\"description\":\"中国日报9月1日电（记者赵磊）8月31日，来自全国各地的6650名硕士、博士研究生新生来到北航报到。在党的二十大即将召开之际和学校七十周年校庆之际，2022级研究生也将在北航扬帆起航，开启人生新篇章。\",\"picUrl\":\"\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138344627303612963\\/\",\"source\":\"中国日报网\"},{\"id\":\"e2df1ea03a484618194db55344840cec\",\"ctime\":\"2022-09-01 17:00:01\",\"title\":\"从化｜倡导绿色生活，温泉镇垃圾分类宣传走进农贸市场\",\"description\":\"为提高辖区居民群众的垃圾分类意识，8月27日上午，温泉镇在温泉市场开展“新时代文明实践 绿色生活月”垃圾分类全民行动日主题活动。活动现场。\",\"picUrl\":\"http:\\/\\/p26.toutiaoimg.com\\/img\\/tos-cn-i-qvj2lq49k0\\/96f3b83e65cb4e0d8ed2726e742c614b~tplv-tt-cs0:1080:821.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138342418285347341\\/\",\"source\":\"微社区e家通\"},{\"id\":\"934b9dda2d1c99341c2344402d315a62\",\"ctime\":\"2022-09-01 17:07:31\",\"title\":\"绝密：战士包围解放军，没想解放军全是特种兵，直接把公安局缴械\",\"description\":\"\",\"picUrl\":\"http:\\/\\/p6.toutiaoimg.com\\/img\\/tos-cn-i-0004\\/c92c7dbd33064397b68e6f58483d2fa5~tplv-tt-cs0:1920:1080.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138331697950491139\\/\",\"source\":\"华数最时尚圈\"},{\"id\":\"3d622188434a3865f019490bb68c9690\",\"ctime\":\"2022-09-01 17:15:01\",\"title\":\"《自然》最新论文：最早的恐龙集中在盘古大陆南端温带区\",\"description\":\"中新网北京9月1日电 国际著名学术期刊《自然》最新发表一篇古生物学研究论文称，气候带影响了早期恐龙分布。\",\"picUrl\":\"http:\\/\\/p26.toutiaoimg.com\\/img\\/tos-cn-i-tjoges91tu\\/TGAbgptIH2nKfq~tplv-tt-cs0:415:540.jpg\",\"url\":\"https:\\/\\/toutiao.com\\/group\\/7138346723050521088\\/\",\"source\":\"北青网\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(body);
        JSONArray newslist = jsonObject.getJSONArray("newslist");
        TouTiaoNews touTiaoNews = jsonObject.toJavaObject(TouTiaoNews.class);
        System.out.println(touTiaoNews);
        return touTiaoNews;
    };

    public static void main(String[] args) {
        XinWenUtils.getTouTiaoNews();
    }

}
