package org.dengo.demo.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberJoinDTO {
  
  private String email;
  private String password;
  private String nickName;
}
