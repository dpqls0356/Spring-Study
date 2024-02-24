package springCorePrinciples.basic.discount;

import springCorePrinciples.basic.member.Grade;
import springCorePrinciples.basic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return 1000;
        }
        return 0;
    }
}
