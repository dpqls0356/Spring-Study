package springCorePrinciples.basic.order;

import springCorePrinciples.basic.discount.DiscountPolicy;
import springCorePrinciples.basic.discount.FixDiscountPolicy;
import springCorePrinciples.basic.member.Member;
import springCorePrinciples.basic.member.MemberRepository;
import springCorePrinciples.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =  memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
