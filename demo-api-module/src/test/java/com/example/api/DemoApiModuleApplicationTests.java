package com.example.api;

import com.example.common.domain.Member;
import com.example.common.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;

import java.util.Optional;

@SpringBootTest
class DemoApiModuleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MemberRepository repository;

    @Test
    @DisplayName("멀티 모듈 테스트")
    public void useCommonDomain() {
        Member member = new Member("sykim", "sdsd");

        repository.save(member);

        Optional<Member> findMemeber = repository.findById(1L);
        findMemeber.ifPresent(find -> Assertions.assertEquals(find.getName(), member.getName()));

    }
}
