/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface CountryDepartmentService {
        
	public List<CountryDepartment> getAll() throws DataAccessException;
        public List<CountryDepartment> findByCountry(Country c) throws DataAccessException;
	public CountryDepartment findOne(Integer code);
	public void delete(CountryDepartment c);
	public void save(CountryDepartment c);
}
