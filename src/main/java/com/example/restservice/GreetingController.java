package com.example.restservice;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/* 相关注解解释：https://www.cnblogs.com/fishpro/p/spring-boot-study-restcontroller.html
  @RestController 处理请求 类、接口（包括注释类型）或枚举声明
  @GetMapping 处理get请求 方法声明
  @RequestParam 处理问号后面的参数 参数声明
*/

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  // 创建一个自动更新的number
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
     // public final 不能被继承。
    // 标记了static才能直接被调用
    // counter.incrementAndGet() 自增1;
    // String.format(template, name) 返回template指定格式的字符串
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}