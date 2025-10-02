package org.dengo.demo.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.dengo.demo.member.dto.MemberJoinDTO;
import org.dengo.demo.member.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Log4j2
public class MemberController {
  
  private final MemberService memberService;
  
  @PostMapping
  @RequestMapping("/join")
  public  Map<String, String>  join(@RequestBody MemberJoinDTO memberJoinDTO) {
    memberService.join(memberJoinDTO);
    return Map.of("RESULT", "SUCCESS");
  }
}
