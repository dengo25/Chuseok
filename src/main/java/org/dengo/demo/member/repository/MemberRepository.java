package org.dengo.demo.member.repository;

import org.dengo.demo.member.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, String> {
  
  @EntityGraph(attributePaths = "memberRoleList")
  @Query("select m from Member m where m.email = :email")
  Member getWithRole(@Param("email") String email);
  
}
