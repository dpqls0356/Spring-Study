package springCorePrinciples.basic;

import springCorePrinciples.basic.discount.FixDiscountPolicy;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;
import springCorePrinciples.basic.member.MemoryMemberRepository;
import springCorePrinciples.basic.order.OrderService;
import springCorePrinciples.basic.order.OrderServiceImpl;

public class AppConfig {
    public static MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    public  static OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
    }
}
