package org.dengo.demo.member.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.*;
import java.util.stream.Collectors;

public class MemberDTO extends User {
  
  private String email;
  private String pw;
  private String nickName;
  
  //화면쪽에서 편리하게 처리하력 string으로
  
  private List<String> roleNames = new ArrayList<>();
  
  public MemberDTO(String email, String password,String nickName, List<String> roleNames) {
    
    super(email, password, roleNames.stream().map(str -> new SimpleGrantedAuthority("ROLE_" + str)).collect(Collectors.toList()));
    
    this.email = email;
    this.pw = password;
    this.nickName = nickName;
    this.roleNames = roleNames;
  }
  
  public Map<String, Object> getClaims() {
    Map<String, Object> dataMap = new HashMap<>();
    dataMap.put("email", email);
    dataMap.put("pw", pw);
    dataMap.put("nickName", nickName);
    dataMap.put("roleNames", roleNames);
    return dataMap;
  }
}
