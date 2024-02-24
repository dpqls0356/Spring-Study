package springCorePrinciples.basic.discount;

import springCorePrinciples.basic.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price );
}
