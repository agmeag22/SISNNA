/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import org.glasswing.domain.User;
import org.glasswing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
        @Override
	public boolean findOneUser(String username, String password) throws DataAccessException {
			boolean result=false;
			if(userRepository.findOneUser(username, password)==1) result=true;
			return result;
	}
        
        @Override
        public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).get();
	}
            
	public void deleteUser(User user) {
		userRepository.delete(user);
		
	}


	@Override
	public void delete(User user) {
		userRepository.delete(user);
		
	}


	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}	
}