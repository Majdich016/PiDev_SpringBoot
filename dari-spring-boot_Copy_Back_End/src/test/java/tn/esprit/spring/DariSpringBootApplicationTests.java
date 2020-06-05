package tn.esprit.spring;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.services.WishListService;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DariSpringBootApplicationTests {
	
	@Autowired
	WishListService ws;

	@Test
	public void contextLoads() throws ParseException {
		//ws.deleteWishList(1);
		//ws.retrieveAllWishLists();
		//ws.retrieveWishList("1");
		

	}

}
