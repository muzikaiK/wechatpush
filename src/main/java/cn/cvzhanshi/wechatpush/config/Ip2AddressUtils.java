package cn.cvzhanshi.wechatpush.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lk
 * @date 2022/8/31 下午 06:06
 */
public class Ip2AddressUtils {
    public static void main(String[] args) {
        Ip2AddressUtils.IP();
    }
    public static String IP(){
        String hostIp = IpUtils.getHostIp();

        RestTemplate restTemplate = new RestTemplate();
        Map<String,String> map = new HashMap<String,String>();
        map.put("ip",hostIp); // 昆山行政代码
        map.put("coor","bd09ll");//这个是数据类型
        map.put("ak","N8fLVUXEF6KChSHY9i8XvSMGpOm6YfMl");
        String res = restTemplate.getForObject(
                "https://api.map.baidu.com/location/ip?ak=N8fLVUXEF6KChSHY9i8XvSMGpOm6YfMl&ip="+"218.4.117.210"+"&coor=gcj02",
        String.class,
                map);
        res = "{\"address\":\"CN|江苏省|苏州市|None|None|100|100\",\"content\":{\"address_detail\":{\"province\":\"江苏省\",\"city\":\"苏州市\",\"adcode\":\"320500\",\"street\":\"\",\"district\":\"\",\"street_number\":\"\",\"city_code\":224},\"address\":\"江苏省苏州市\",\"point\":{\"x\":\"120.58599958\",\"y\":\"31.29730099\"}},\"status\":0}\n";
        JSONObject json = JSONObject.parseObject(res);
        System.out.println(json);
        return json.toString();
    }
}
