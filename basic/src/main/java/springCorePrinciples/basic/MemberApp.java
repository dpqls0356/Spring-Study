package springCorePrinciples.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springCorePrinciples.basic.member.Grade;
import springCorePrinciples.basic.member.Member;
import springCorePrinciples.basic.member.MemberService;
import springCorePrinciples.basic.member.MemberServiceImpl;

public class MemberApp {
    //순수 자바 코드
    public static void main(String[] args) {
//        MemberService memberService = AppConfig.memberService();
//        스프링으로 바꾸기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        System.out.println(member.getName());
        System.out.println(findMember.getName());
    }
}
