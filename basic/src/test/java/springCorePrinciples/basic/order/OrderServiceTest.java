package springCorePrinciples.basic.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springCorePrinciples.basic.member.Grade;
import springCorePrinciples.basic.member.Member;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
