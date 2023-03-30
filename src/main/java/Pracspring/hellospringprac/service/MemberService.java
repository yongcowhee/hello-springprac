package Pracspring.hellospringprac.service;

import Pracspring.hellospringprac.domain.Member;
import Pracspring.hellospringprac.repository.MemberRepository;
import Pracspring.hellospringprac.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Spring에 올라올 때 Service네 하고 Spring 컨테이너에 MemberService를 등록해줌
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */

    public Long join(Member member){
        //같은 이름이 있는 중복 회원X
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // null일 가능성이 있으면 Optional로 감싸서 반환, 직접 바로 꺼내는 것을 권장하지 않음
                .ifPresent(m -> { // findByName의 결과값이 이미 Optional 이므로 바로 ifPresent 사용
                   throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}
