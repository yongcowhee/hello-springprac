package Pracspring.hellospringprac.controller;

import Pracspring.hellospringprac.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller 어노테이션이 붙으면 Spring 컨테이너에 MemberController 객체를 생성해서 넣어두고 Spring이 관리함
@Controller
public class MemberController {
    private final MemberService memberService;

    //생성자에 @Autowired 어노테이션이 붙으면 스프링 컨테이너에 있는 memberService를 Spring이 연결 시켜줌
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
