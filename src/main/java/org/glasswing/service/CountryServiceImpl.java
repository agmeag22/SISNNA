/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository committeeRepository;
	
	
      
        
        @Override
        public Country findOne(Integer id) {
		// TODO Auto-generated method stub
		return committeeRepository.findById(id).get();
	}
            
	public void deleteCountry(Country committee) {
		committeeRepository.delete(committee);
		
	}


	@Override
	public void delete(Country committee) {
		committeeRepository.delete(committee);
		
	}


	@Override
	public void save(Country committee) {
		committeeRepository.save(committee);
		
	}	

    @Override
    public List<Country> getAll() throws DataAccessException {
        return committeeRepository.findAll();
    }

    @Override
    public List<Country> findNotUsedCountries() throws DataAccessException {
        return committeeRepository.findNotUsedCountries();
    }
}