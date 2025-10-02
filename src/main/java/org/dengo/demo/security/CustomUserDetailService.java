package org.dengo.demo.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dengo.demo.member.dto.MemberDTO;
import org.dengo.demo.member.entity.Member;
import org.dengo.demo.member.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class CustomUserDetailService implements UserDetailsService {
  
  private final MemberRepository memberRepository;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    log.info("--------loadUserByUsername---------" + username);
    Member member = memberRepository.getWithRole(username);
    
    if (member == null) {
      throw new UsernameNotFoundException("Not Found");
    }
    
    MemberDTO memberDTO = new MemberDTO(
        member.getEmail(),
        member.getPw(),
        member.getNickName(),
        member.getMemberRoleList()
            .stream()
            .map(memberRole -> memberRole.name()).collect(Collectors.toList())
    );
    
    log.info(memberDTO);
    
    
    return memberDTO;
  }
}
