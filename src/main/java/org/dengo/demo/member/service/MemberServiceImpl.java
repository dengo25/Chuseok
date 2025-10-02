package org.dengo.demo.member.service;

import lombok.RequiredArgsConstructor;
import org.dengo.demo.member.dto.MemberJoinDTO;
import org.dengo.demo.member.entity.Member;
import org.dengo.demo.member.entity.MemberRole;
import org.dengo.demo.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
  
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  
  
  @Override
  public void join(MemberJoinDTO dto) {
    
    if (memberRepository.existsById(dto.getEmail())) {
      throw new IllegalArgumentException("이미 존재하는 이메일입니다");
    }
    
    Member member = joinDtoToEntity(dto);
    
    String encodedPassword = passwordEncoder.encode(dto.getPassword());
    
    member.changePw(encodedPassword);
    
    member.addRole(MemberRole.USER);
    
    memberRepository.save(member);
  }
}