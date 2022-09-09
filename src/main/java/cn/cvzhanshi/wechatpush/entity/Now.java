package cn.cvzhanshi.wechatpush.entity;

import lombok.Data;

/**
 * @author lk
 * @date 2022/8/31 下午 05:38
 */
@Data
public class Now {
    private Integer temp;
    private Integer feels_like;
    private Integer rh;
    private String wind_class;
    private String wind_dir;
    private String text;
    private String uptime;
}
