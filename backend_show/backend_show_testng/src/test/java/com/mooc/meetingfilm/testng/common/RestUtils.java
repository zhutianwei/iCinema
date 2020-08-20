package com.mooc.meetingfilm.testng.common;

import org.springframework.web.client.RestTemplate;

/**
 * @author : Z
 * @program : com.mooc.meetingfilm.testng.common
 * @description :
 **/
public class RestUtils {

    private static RestTemplate restTemplate;

    public static RestTemplate getRestTemplate(){
        if(restTemplate!=null){
            return restTemplate;
        }else{
            restTemplate = new RestTemplate();
            return restTemplate;
        }
    }

}
