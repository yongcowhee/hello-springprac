package Pracspring.hellospringprac;

import Pracspring.hellospringprac.repository.MemberRepository;
import Pracspring.hellospringprac.repository.MemoryMemberRepository;
import Pracspring.hellospringprac.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
