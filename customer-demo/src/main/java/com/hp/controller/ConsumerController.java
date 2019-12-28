package com.hp.controller;


import com.hp.client.UserClient;
import com.hp.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
                            /*第四步 ----编写降级逻辑*/
@RestController
@RequestMapping("consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {
    @Autowired
    private UserClient userClient;
   /* @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;*/

//    @GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//       User user= restTemplate.getForObject("http://localhost:8089/user/"+id,User.class);
//        return user;
//    }

//    @GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//        //获取服务列表
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //列表中获取一个服务实例
//        ServiceInstance serviceInstance = instances.get(0);
//        String url="http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/user/"+id;
//        User user= restTemplate.getForObject(url,User.class);
//        return user;
//    }

//    @GetMapping("/{i}")
//    public User getUser(@PathVariable("i") Long id){
//        String url="http://user-service/user/"+id;
//        User user= restTemplate.getForObject(url,User.class);
//        return user;
//    }

                                 //快速熔断（方法一）
/*    @GetMapping("/{i}")
    @HystrixCommand(fallbackMethod = "queryByIdFallback")
    public String getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;
        String user= restTemplate.getForObject(url,String.class);
        return user;
    }
    public String queryByIdFallback(Long id){
        return "服务器失联";
    }*/


                            //快速熔断（方法二）         默认FallBack
/*    @GetMapping("/{i}")
    @HystrixCommand
    public String getUser(@PathVariable("i") Long id){
        String url="http://user-service/user/"+id;
        String user= restTemplate.getForObject(url,String.class);
        return user;
    }
    public String defaultFallback(){
        return "服务器失联";
    }*/

    //快速熔断（方法三）
    @GetMapping("/{i}")
   // @HystrixCommand
    public User getUser(@PathVariable("i") Long id){
        /*String url="http://user-service/user/"+id;
        String user= restTemplate.getForObject(url,String.class);*/
        return userClient.queryById(id);
    }
    /*public String defaultFallback(){
        return "服务器失联";
    }*/

}
