package basic.core;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import basic.core.member.Grade;
import basic.core.member.Member;
import basic.core.member.MemberService;
import basic.core.order.Order;
import basic.core.order.OrderService;

public class OrderServiceImplTest {

    private MemberService memberService;
    private OrderService orderService;
    
    @BeforeEach
    public void setUp() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }   


    @Test
    public void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}
