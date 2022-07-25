package com.cg.pizzaorder.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.repository.IAdminRepository;
import com.cg.pizzaorder.service.IAdminService;



@Service
public class AdminDao  implements IAdminService{

	@Autowired
	IAdminRepository adminRepository;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(AdminDao.class);

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRepository.save(admin);
		
	}

	@Override
	public int deleteAdmin(int adminId)  {
		Optional<Admin> admin = adminRepository.findById(adminId);	
		Admin a = null;			
		if (admin.isPresent()) {
			a = admin.get();					
			adminRepository.delete(a);
		}else {
			
		}
		return adminId;	
	}

	@Override
	public String getAdminName(int adminId) {
		// fetching admin user name
		return adminRepository.getAdminName(adminId);
	}

	@Override
	public String getAdminPassword(int adminId) {
		// fetching admin passsword
		return adminRepository.getAdminPassword(adminId);
	}


	@Override
	public List<Admin> viewAdmins() {
		List<Admin> list = adminRepository.findAll();
		//logger.info("Customer Details are Fetched");
		return list;
	}

	@Override
	public Admin getLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			return adminRepository.getLogin(userName,userPassword);
		}
	}
	

