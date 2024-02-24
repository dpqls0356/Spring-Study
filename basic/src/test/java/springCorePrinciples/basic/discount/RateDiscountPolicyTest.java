package springCorePrinciples.basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import springCorePrinciples.basic.member.Grade;
import springCorePrinciples.basic.member.Member;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 되어야한다.")
    void vip_o(){
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("BASIC은 10% 할인이 되지않아야한다.")
    void vip_x(){
        Member member = new Member(2L,"memberBASIC", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        assertThat(discount).isEqualTo(0);
    }
}