package springCorePrinciples.basic;

import springCorePrinciples.basic.member.Grade;
import springCorePrinciples.basic.member.Member;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;
import springCorePrinciples.basic.order.Order;
import springCorePrinciples.basic.order.OrderService;
import springCorePrinciples.basic.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = "+order);
        System.out.println("order = "+order.calculatePrice());

    }
}
