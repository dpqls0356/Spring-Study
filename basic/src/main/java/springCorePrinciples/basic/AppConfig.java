package springCorePrinciples.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springCorePrinciples.basic.discount.DiscountPolicy;
import springCorePrinciples.basic.discount.FixDiscountPolicy;
import springCorePrinciples.basic.discount.RateDiscountPolicy;
import springCorePrinciples.basic.member.MemberRepository;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;
import springCorePrinciples.basic.member.MemoryMemberRepository;
import springCorePrinciples.basic.order.OrderService;
import springCorePrinciples.basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public static MemberService memberService(){
        return new MemberServiceImpl(getMemberRepository());
    }
    @Bean
    //MemoryMemberRepository 중복 호출을 없앴다.
    public static MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public  static OrderService orderService(){
        return new OrderServiceImpl((MemoryMemberRepository) getMemberRepository(),discountPolicy());
    }
    @Bean
    public static DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
