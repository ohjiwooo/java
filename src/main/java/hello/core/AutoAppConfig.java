package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //스캔 시작 위치 - 지정하지 않을 시 현재 클래스의 package 가 시작위치 -> 현재 클래스를 최상단에 둠
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)
public class AutoAppConfig {


}
