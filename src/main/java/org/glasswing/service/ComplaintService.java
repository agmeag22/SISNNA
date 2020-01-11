/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Committee;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface ComplaintService {

	public List<Committee> getAll() throws DataAccessException;
	public Committee findOne(Integer code);
	public void delete(Committee c);
	public void save(Committee c);
}
