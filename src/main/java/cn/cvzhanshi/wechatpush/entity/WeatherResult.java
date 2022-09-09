package cn.cvzhanshi.wechatpush.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lk
 * @date 2022/8/31 下午 03:29
 */
@Data
public class WeatherResult implements Serializable {
    private Location location;
    private Now now;
    private List<Forecasts> forecasts;
    @Data
    class Forecasts{
        private String date;
        private String week;
        private String high;
        private String low;
        private String wc_day;
        private String wc_night;
        private String wd_day;
        private String wd_night;
        private String text_day;
        private String text_night;
    }
}
