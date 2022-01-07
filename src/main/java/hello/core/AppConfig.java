package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepo;
import hello.core.member.MemberService;
import hello.core.member.MemberserviceImpl;
import hello.core.member.MemoryMemberRepo;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberserviceImpl(memberRepo());
    }

    private MemberRepo memberRepo() {
        return new MemoryMemberRepo();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepo(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
