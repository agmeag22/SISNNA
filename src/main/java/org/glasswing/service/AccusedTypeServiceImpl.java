/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;
import java.util.List;
import org.glasswing.domain.AccusedType;
import org.glasswing.repositories.AccusedTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;



@Service
public class AccusedTypeServiceImpl implements AccusedTypeService {
	
	@Autowired
	AccusedTypeRepository accusedTypeRepository;
	
	
      
        
        @Override
        public AccusedType findOne(Integer id) {
		// TODO Auto-generated method stub
		return accusedTypeRepository.findById(id).get();
	}
            
	public void deleteAccusedType(AccusedType accusedType) {
		accusedTypeRepository.delete(accusedType);
		
	}


	@Override
	public void delete(AccusedType accusedType) {
		accusedTypeRepository.delete(accusedType);
		
	}


	@Override
	public void save(AccusedType accusedType) {
		accusedTypeRepository.save(accusedType);
		
	}	

    @Override
    public List<AccusedType> getAll() throws DataAccessException {
        return accusedTypeRepository.findAll();
    }
}