package Pracspring.hellospringprac.controller;

import Pracspring.hellospringprac.domain.Member;
import Pracspring.hellospringprac.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller 어노테이션이 붙으면 Spring 컨테이너에 MemberController 객체를 생성해서 넣어두고 Spring이 관리함
@Controller
public class MemberController {
    private final MemberService memberService;

    //생성자에 @Autowired 어노테이션이 붙으면 스프링 컨테이너에 있는 memberService를 Spring이 연결 시켜줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

}
