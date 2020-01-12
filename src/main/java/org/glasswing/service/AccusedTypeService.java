/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.AccusedType;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface AccusedTypeService {

	public List<AccusedType> getAll() throws DataAccessException;
	public AccusedType findOne(Integer code);
	public void delete(AccusedType c);
	public void save(AccusedType c);
}
