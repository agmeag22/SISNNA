/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Municipality;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface MunicipalityService {
        
	public List<Municipality> getAll() throws DataAccessException;
        public List<Municipality> findByCountryDepartment(CountryDepartment c) throws DataAccessException;
	public Municipality findOne(Integer code);
	public void delete(Municipality c);
	public void save(Municipality c);
}
