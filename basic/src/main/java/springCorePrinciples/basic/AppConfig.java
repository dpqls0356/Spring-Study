package springCorePrinciples.basic;

import springCorePrinciples.basic.discount.DiscountPolicy;
import springCorePrinciples.basic.discount.FixDiscountPolicy;
import springCorePrinciples.basic.discount.RateDiscountPolicy;
import springCorePrinciples.basic.member.MemberRepository;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;
import springCorePrinciples.basic.member.MemoryMemberRepository;
import springCorePrinciples.basic.order.OrderService;
import springCorePrinciples.basic.order.OrderServiceImpl;

public class AppConfig {
    public static MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }

    //MemoryMemberRepository 중복 호출을 없앴다.
    private static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    public  static OrderService orderService(){
        return new OrderServiceImpl((MemoryMemberRepository) getMemberRepository(),discountPolicy());
    }
    public static DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
