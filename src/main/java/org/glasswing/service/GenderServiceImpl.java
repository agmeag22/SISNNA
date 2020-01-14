/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import java.util.List;
import org.glasswing.domain.Gender;
import org.glasswing.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class GenderServiceImpl implements GenderService {
	
	@Autowired
	GenderRepository GenderRepository;
	
	
      
        
        @Override
        public Gender findOne(Integer id) {
		// TODO Auto-generated method stub
		return GenderRepository.findById(id).get();
	}
            
	public void deleteGender(Gender Gender) {
		GenderRepository.delete(Gender);
		
	}


	@Override
	public void delete(Gender Gender) {
		GenderRepository.delete(Gender);
		
	}


	@Override
	public void save(Gender Gender) {
		GenderRepository.save(Gender);
		
	}	

    @Override
    public List<Gender> getAll() throws DataAccessException {
        return GenderRepository.findAll();
    }
}