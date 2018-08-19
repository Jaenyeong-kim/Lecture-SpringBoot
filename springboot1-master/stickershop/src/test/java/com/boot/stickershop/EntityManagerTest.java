package com.boot.stickershop;

import com.boot.stickershop.domain.User;
import com.boot.stickershop.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EntityManagerTest {
	@Autowired
	EntityManager entityManager;

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindUser() throws Exception{
		User user = entityManager.find(User.class, 1L);
		System.out.println(user);
	}

	@Test
	public void testPersistUser() throws Exception{
		User user = new User();
		user.setEmail("carami@gmail.com");
		user.setName("kang");
		user.setPassword("1234");
		user.setRegtime(LocalDateTime.now());
		entityManager.persist(user);
		System.out.println(user.getId());
	}

	@Test
	public void testSaveUser() throws Exception{
		User user = new User();
		user.setEmail("carami@gmail.com");
		user.setName("kang");
		user.setPassword("1234");
		user.setRegtime(LocalDateTime.now());
		System.out.println("-----------------------------------------");
		userRepository.save(user);
		System.out.println(user.getId());
		System.out.println("-----------------------------------------");
	}
}
