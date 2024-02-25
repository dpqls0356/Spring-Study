package springCorePrinciples.basic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springCorePrinciples.basic.AppConfig;

public class MemberServiceTest {
    MemberService memberService = AppConfig.memberService();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        memberService.join(member);
        //when
        Member findMember = memberService.findMember(member.getId());
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
