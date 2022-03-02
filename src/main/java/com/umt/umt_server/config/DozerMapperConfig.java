package com.umt.umt_server.config;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DozerMapper(객체와 객체끼리 매핑을 할 때 쉽게 할 수 있도록 도와주는 라이브러리)
 * 를 위한 Config 파일 입니다.
 */
@Configuration
public class DozerMapperConfig {
    @Bean
    public Mapper dozerMapper() {
        return DozerBeanMapperBuilder.buildDefault();
    }
}
