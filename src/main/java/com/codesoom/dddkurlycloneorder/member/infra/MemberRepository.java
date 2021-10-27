package com.codesoom.dddkurlycloneorder.member.infra;

import com.codesoom.dddkurlycloneorder.member.domain.models.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
}
