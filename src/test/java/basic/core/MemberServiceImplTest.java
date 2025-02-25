package basic.core;

import basic.core.member.Member;    
import basic.core.member.MemberService;
import basic.core.member.Grade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceImplTest {

    private MemberService memberService;

    @BeforeEach
    public void setUp() {
        // MemberServiceImpl은 내부에서 MemoryMemberRepository를 생성하므로 별도 주입이 필요없습니다.
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    public void testJoinAndFindMember() {
        Member member = new Member(1L, "홍길동", Grade.BASIC);
        // 필요한 경우 추가 필드를 설정합니다. 예: member.setName("홍길동");
        
        // 회원 가입 처리
        memberService.join(member);
        
        // 가입된 회원을 id로 조회
        Member foundMember = memberService.findMember(1L);
        
        // 회원이 null이 아님을 확인
        assertNotNull(foundMember, "회원 가입 후 조회된 회원은 null이 아니어야 합니다.");
        
        // id가 일치하는지 확인
        assertEquals(member.getId(), foundMember.getId(), "회원의 id가 일치해야 합니다.");
    }

} 