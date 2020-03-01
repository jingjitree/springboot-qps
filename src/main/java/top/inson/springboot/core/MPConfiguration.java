package top.inson.springboot.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "top.inson.springboot.dao")
public class MPConfiguration {


}
