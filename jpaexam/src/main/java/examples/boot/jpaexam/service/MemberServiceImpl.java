package examples.boot.jpaexam.service;

import examples.boot.jpaexam.domain.Member;
import examples.boot.jpaexam.domain.MemberRole;
import examples.boot.jpaexam.repository.MemberRepository;
import examples.boot.jpaexam.repository.MemberRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberRoleRepository memberRoleRepository;

    @Override
    @Transactional
    public Member addMember(Member member) {
        // 파라미터 member (name, email, password)
        // password 암호화하여 다시 설정
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        // 날짜 정보도 설정
        member.setJoinDate(LocalDateTime.now());
        // MemberRole에 대한 설정, MemberRoleRepository를 생성
        // role name이 "ROLE_USER" 인 것을 읽어서 Member의 MemberRoles에 설정
        Set<MemberRole> memberRoles = new HashSet<>();
        member.setMemberRoles(memberRoles);
        member = memberRepository.save(member);

        // Member를 저장, 리턴
        return member;
    }

    @Override
    @Transactional(readOnly = true) // readOnly 설정 시 커밋이 안되서 성능이 느려지지 않음
    public Member getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
}
