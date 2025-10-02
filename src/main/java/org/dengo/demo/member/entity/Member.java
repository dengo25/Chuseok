package org.dengo.demo.member.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "members")
@Builder
public class Member {
  
  @Id
  private String email;
  
  private String pw;
  
  private String nickName;
  
  @ElementCollection(fetch = FetchType.LAZY)
  @Builder.Default
  private List<MemberRole> memberRoleList = new ArrayList<>();
  
  public void addRole(MemberRole memberRole) {
    memberRoleList.add(memberRole);
  }
  
  public void clearRole() {
    memberRoleList.clear();
  }
  
  public void changeNickName(String nickName) {
    this.nickName = nickName;
  }
  
  public void changePw(String password) {
    this.pw = password;
  }
}
