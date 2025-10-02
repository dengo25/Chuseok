package org.dengo.demo.member.repository;

import org.dengo.demo.member.entity.Member;
import org.dengo.demo.member.entity.MemberRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
  
  @Autowired
  private MemberRepository memberRepository;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  
  @Test
  void registerMember() {
    memberRepository.deleteAll();
    
    for (int i = 0; i < 10; i++) {
      Member member = Member.builder()
          .email("test" + i + "@test.com")
          .nickName("testName..." + i)
          .pw(passwordEncoder.encode("test"))
          .build();
      
      member.addRole(MemberRole.USER);
      
      if (i > 5) {
        member.addRole(MemberRole.MANAGER);
        
      }
      
      if (i > 8) {
        member.addRole(MemberRole.ADMIN);
        
      }
      
      memberRepository.save(member);
      System.out.println("Saved: " + member.getEmail() +
          ", Roles: " + member.getMemberRoleList());
    }
    

  }
  
  @Test
  void testRead() {
    String email = "test@test.com";
    Member withRole = memberRepository.getWithRole(email);
    System.out.println(withRole);
    
  }
  
  
}