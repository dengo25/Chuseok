package org.dengo.demo.member.service;

import org.dengo.demo.member.dto.MemberJoinDTO;
import org.dengo.demo.member.entity.Member;

public interface MemberService {
  
  
  void join(MemberJoinDTO dto);
  
  
  //회원가입용
  default Member joinDtoToEntity(MemberJoinDTO dto) {
    return Member.builder()
        .email(dto.getEmail())
        .pw(dto.getPassword())
        .nickName(dto.getNickName())
        .build();
  }
}