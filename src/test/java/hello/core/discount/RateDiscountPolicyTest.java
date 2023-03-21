package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("vip 는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member memberVIP = new Member(1L, "memberVIP", Grade.Vip);
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야한다.")
    void vip_x(){
        //given
        Member memberVIP = new Member(2L, "memberBasic", Grade.Basic);
        //when
        int discount = discountPolicy.discount(memberVIP, 10000);
        //then
        assertThat(discount).isEqualTo(0);
    }
}