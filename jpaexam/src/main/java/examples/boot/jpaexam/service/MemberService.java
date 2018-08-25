package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Member;

public interface MemberService {
    Member addMember(Member member);
    Member getMemberByEmail(String email);
}
