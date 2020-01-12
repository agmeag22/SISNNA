/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import java.util.List;
import org.glasswing.domain.Abuse;
import org.glasswing.repositories.AbuseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class AbuseServiceImpl implements AbuseService {
	
	@Autowired
	AbuseRepository abuseRepository;
	
	
      
        
        @Override
        public Abuse findOne(Integer id) {
		// TODO Auto-generated method stub
		return abuseRepository.findById(id).get();
	}
            
	public void deleteAbuse(Abuse abuse) {
		abuseRepository.delete(abuse);
		
	}


	@Override
	public void delete(Abuse abuse) {
		abuseRepository.delete(abuse);
		
	}


	@Override
	public void save(Abuse abuse) {
		abuseRepository.save(abuse);
		
	}	

    @Override
    public List<Abuse> getAll() throws DataAccessException {
        return abuseRepository.findAll();
    }
}