package cn.cvzhanshi.wechatpush.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lk
 * @date 2022/9/10 上午 01:34
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/demo")
    public String test(){
        return "hello world! "+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
