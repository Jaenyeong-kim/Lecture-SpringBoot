package examples.boot.web1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Transactional
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void configTest(){

    }

    @Test
    public void addMember() throws Exception{
        Member member = new Member("kim", "urstory@gmail.com");
        member = memberRepository.save(member);
        Assert.assertNotNull(member.getId());
    }

}
