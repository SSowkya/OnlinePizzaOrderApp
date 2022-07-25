package com.cg.pizzaorder;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.pizzaorder.dao.AdminDao;
import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.repository.IAdminRepository;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import javax.persistence.EntityExistsException;

@SpringBootTest
@ActiveProfiles("test")
class OnlinePizzaOrderApplicationTests {
	@Autowired
	private IAdminRepository adminRepos;
	@Autowired
	private AdminDao service;

	@Test
	public void testSave() {
		Admin admin = new Admin();
		admin.setAdminName("SindhuRam");
		admin.setAdminPassword("sindhu@123");
		Admin t = null;
		try {
			t = service.addAdmin(admin);
		} catch (EntityExistsException e) {
			System.out.print("Couldn't Add the Admin Details");
			e.printStackTrace();
		}

	}

	
	  @Test public void testForDelete() { 
		  Integer id = 32; 
		boolean  isExistBeforeDelete = adminRepos.findById(id).isPresent();
	  adminRepos.deleteById(id); 
	  boolean notExistsAfterDelete =  adminRepos.findById(id).isPresent(); assertTrue(isExistBeforeDelete);
	  assertFalse(notExistsAfterDelete); 
	  }
	 

	@Test
	public void testForshowAllAdmins() {
		List<Admin> list = service.viewAdmins();
		assertThat(list).size().isGreaterThan(0);

	}
}