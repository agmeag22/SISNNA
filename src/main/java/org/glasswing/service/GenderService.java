/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Gender;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface GenderService {

	public List<Gender> getAll() throws DataAccessException;
	public Gender findOne(Integer code);
	public void delete(Gender c);
	public void save(Gender c);
}
