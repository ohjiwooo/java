package hello.core.beanFind;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepo;
import hello.core.member.MemoryMemberRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplocationContextSameBeamFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상있으면, 중복오류 발생")
    void FindByTypeDuplicate(){
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepo.class));
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이사이 있으면, 빈 이름을 지정하면 됨")
    void FindBeanByName(){
        MemberRepo memberRepo = ac.getBean("memberRepo1", MemberRepo.class);
        org.assertj.core.api.Assertions.assertThat(memberRepo).isInstanceOf(MemoryMemberRepo.class);

    }

    @Test
    @DisplayName("특정 타입 모두 조회")
    void FindAllBeanByType(){
        Map<String, MemberRepo> beansOfType = ac.getBeansOfType(MemberRepo.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

    }


    @Configuration
    static class SameBeanConfig{

        @Bean
        public MemberRepo memberRepo1(){
            return new MemoryMemberRepo();
        }
        @Bean
        public MemberRepo memberRepo2(){
            return new MemoryMemberRepo();
        }

    }
}
