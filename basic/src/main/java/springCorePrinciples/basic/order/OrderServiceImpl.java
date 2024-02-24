package springCorePrinciples.basic.order;

import springCorePrinciples.basic.discount.DiscountPolicy;
import springCorePrinciples.basic.discount.FixDiscountPolicy;
import springCorePrinciples.basic.discount.RateDiscountPolicy;
import springCorePrinciples.basic.member.Member;
import springCorePrinciples.basic.member.MemberRepository;
import springCorePrinciples.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
/*
//    할인 정책을 바꾸면서 DIP위반
//    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
*/

//    위반된 DIP를 인터페이스에만 의존하도록 바꿈
//    대신 할인정책을 주입해줘야한다.
    private DiscountPolicy discountPolicy;

    MemberRepository memberRepository;

    public OrderServiceImpl(MemoryMemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
