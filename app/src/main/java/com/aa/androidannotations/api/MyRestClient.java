package com.aa.androidannotations.api;

import com.aa.androidannotations.model.Err;

import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by 6193 on 2016/4/18.
 */
@Rest(converters = { MappingJackson2HttpMessageConverter.class, StringHttpMessageConverter.class })
public interface MyRestClient {

    @Post("http://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx9c61ca4d88538922&secret=f3aac1609d3a0ced1ff6d54f5157f740")
    Err getErr();

}