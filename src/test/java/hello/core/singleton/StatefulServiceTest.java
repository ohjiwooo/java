package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService stateService1 = ac.getBean(StatefulService.class);
        StatefulService stateService2 = ac.getBean(StatefulService.class);

        stateService1.order("userA",10000);
        stateService1.order("userB",20000);

        int price = stateService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(stateService1.getPrice()).isEqualTo(20000);

        //무상태로 설계해야함 - 공유필드 조심
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}