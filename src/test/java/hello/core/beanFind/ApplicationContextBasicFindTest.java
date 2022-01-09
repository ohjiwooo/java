package hello.core.beanFind;


import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberserviceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberserviceImpl.class);
    }

    @Test
    @DisplayName("구체타입으로 조회") //유연성 떨어짐
    void findBeanByName2(){

        MemberserviceImpl memberService = ac.getBean("memberService", MemberserviceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberserviceImpl.class);
    }
}
