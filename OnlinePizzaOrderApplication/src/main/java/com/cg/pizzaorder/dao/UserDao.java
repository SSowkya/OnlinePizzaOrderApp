package com.cg.pizzaorder.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.pizzaorder.exception.InvalidLoginException;
import com.cg.pizzaorder.exception.NoSuchCustomerException;
import com.cg.pizzaorder.exception.NoSuchPizzaException;
import com.cg.pizzaorder.model.Admin;
import com.cg.pizzaorder.model.Pizza;
import com.cg.pizzaorder.model.User;
import com.cg.pizzaorder.repository.IUserRepository;
import com.cg.pizzaorder.service.IUserService;

@Service
public class UserDao implements IUserService {
	@Autowired
	IUserRepository userRepository;
	Logger logger = org.slf4j.LoggerFactory.getLogger(UserDao.class);

	@Override
	public User signIn(User user) throws InvalidLoginException {
		Optional<User> uu = userRepository.findById(user.getUserId());

		User u2 = uu.get();

		if (u2.getUserPassword().equals(user.getUserPassword()) && u2.getUserName().equals(user.getUserName())) {
			System.out.println("login successfull");
			return u2;
		} else {
			System.out.println("login incomplete");
			// throw new SignInException("login unsuccessful!");
			throw new InvalidLoginException("login unsuccessful");
		}

	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		Optional<User> uu = userRepository.findById(user.getUserId());

		User u2 = uu.get();
		u2.setUserName("");
		u2.setUserPassword("");
		if (u2.getUserName().isBlank() && u2.getUserPassword().isBlank()) {
			System.out.println("logout successfull");
			return u2;
		} else {
			System.out.println("logout incomplete");
			throw new InvalidLoginException("logout unsuccessful");
		}

	}

	public User findbyid(int id) {
		return userRepository.findById(id).orElseThrow(() -> new InvalidLoginException("User does not exist"));

	}

	@Override
	public boolean forgetPassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		int status=0;
		
		status=userRepository.UpdatePassword(newPassword, oldPassword);
		if(status>=1)
		{
			return true;
		}
		return false;
	}

	@Override
	public User getLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			return userRepository.getLogin(userName,userPassword);
		}
	

	@Override
	public User viewUser(int userId) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		Optional<User> found = userRepository.findById(userId);
		if(found.isPresent()) {
			return found.get();
		}else {
			throw new NoSuchCustomerException("This User does not exist");
		}
	}

	
	
}
