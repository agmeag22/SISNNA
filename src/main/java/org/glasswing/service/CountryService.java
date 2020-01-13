/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Country;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface CountryService {

	public List<Country> getAll() throws DataAccessException;
	public Country findOne(Integer code);
	public void delete(Country c);
	public void save(Country c);
}
