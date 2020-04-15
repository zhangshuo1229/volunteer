package com.hbsx.project.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Description MVC 配置类
 * @Author wangxiancheng
 * @Date 2019/5/8 11:03
 * @Copyright 安徽华博胜讯信息科技股份有限公司
 **/
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	private static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	* @Description: 进行时间统一格式化
	* @param: registry
	* @return:
	*
	**/
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	registry.addFormatter(new DateFormatter(DEFAULT_DATETIME_FORMAT));
    	super.addFormatters(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
	}

	/**
	* @Description: 时间得相关转化
	* @param:
	* @return:
	*
	**/
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(0,new MappingJackson2HttpMessageConverter());
		for(HttpMessageConverter<?> converter : converters) {
			if(converter instanceof MappingJackson2HttpMessageConverter) {
				MappingJackson2HttpMessageConverter messageConverter = (MappingJackson2HttpMessageConverter) converter;
				messageConverter.getObjectMapper().setDateFormat(new SimpleDateFormat(DEFAULT_DATETIME_FORMAT));
			}
		}
	}

}
