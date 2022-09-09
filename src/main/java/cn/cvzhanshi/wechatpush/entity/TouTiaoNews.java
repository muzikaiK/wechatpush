package cn.cvzhanshi.wechatpush.entity;

import lombok.Data;

import java.util.List;

/**
 * @author lk
 * @date 2022/9/1 下午 06:37
 */
@Data
public class TouTiaoNews {
    private List<TouTiao> newslist;
    @Data
    public class TouTiao {
        private String id;
        private String ctime;
        private String title;
        private String picUrl;
        private String url;
        private String source;
    }


}
