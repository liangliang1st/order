package com.hjl.order.controller;

import com.hjl.order.client.ClientPro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ClientController
 * @AUthor hanjialiang
 * @Date 2019-04-11 08:46
 * @Version 1.0
 * @Description
 */
@RestController
@Slf4j
public class ClientControllerTest {
    /*  @Autowired
      private LoadBalancerClient loadBalancerClient;
  */
    @Autowired
    private RestTemplate restTemplate;
   /* @Autowired
    private ClientPro testClient;*/

    @GetMapping("/getMsg")
    public String getProductMsg() {
        String response="";
        //1、第一种方式（直接使用RestTemplate，url写死），地址不确定，麻烦，服务方多集群就不好访问。
        /*RestTemplate restTemplate=new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
        log.info("response={}",response);*/

        //2、第二种方式（利用loadBalancerClient通过应用名获取url，再用RestTemplate），每次都需要格式化，并取，不方便
       /* RestTemplate restTemplate=new RestTemplate();
        //获取应用名字
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url=String.format("http://%s:%s",serviceInstance.getHost(),serviceInstance.getPort())+"/msg";
        String response = restTemplate.getForObject(url, String.class);
        return response;*/

       //3、第三种方法（创建config类，用@LoadBlance注解）

//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);

        //4
//        String response=testClient.getMsg();
        log.info("response={}",response);
        return response;

    }

}
