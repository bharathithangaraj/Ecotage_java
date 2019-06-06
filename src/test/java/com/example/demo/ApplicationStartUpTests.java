package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationStartUpTests.class)
public class ApplicationStartUpTests {

//	@Autowired
//	AccountRepository accountRepository;
	
	/*@Autowired
	ProductRepositry productRepo;*/
	
	@Test
	public void contextLoads() {
//		Account account = accountRepository.save(new Account().setAccountNumber("ABCD").setName("Support"));
//		Assert.assertNotNull(account.getId());
		
		
	}

}
