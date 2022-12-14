package com.example.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/* https://zhuanlan.zhihu.com/p/73257985
@Bean
Spring的@Bean注解用于告诉方法，产生一个Bean对象，然后这个Bean对象交给Spring管理。
产生这个Bean对象的方法Spring只会调用一次，
随后这个Spring将会将这个Bean对象放在自己的IOC容器中。
SpringIOC 容器管理一个或者多个bean，
这些bean都需要在@Configuration注解下进行创建，
在一个方法上使用@Bean注解就表明这个方法需要交给Spring进行管理。
@SpringBootApplication
声明一个或多个@Bean方法并触发自动配置和组件扫描的配置类。这是一个方便的注释，
相当于声明@Configuration、@EnableAutoConfiguration和@ComponentScan。
rest restful 都是和接口或http有关
*/

@SpringBootApplication
public class ConsumingRestApplication {

  private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConsumingRestApplication.class, args);
  }

  /* spring 自动生成 restTemplate对象
     spring 自动生成run 对象
     run 对象调用 restTemplate对象的方法。
     RestTemplateBuilder 变成模板
     build() 构建模板的方法，构建模板都是用他来收尾。
  */
  @Bean
  public RestTemplate restTemplate(RestTemplateBuilder builder) {
    return builder.build();
  }

  // CommandLineRunner 用于指示bean在包含在SpringApplication中时运行方式
  @Bean
  public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
    return args -> {
      Quote quote = restTemplate.getForObject(
        "http://localhost:8080/api/1", Quote.class);
      log.info(quote.toString());
    };
  }
}