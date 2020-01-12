/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Abuse;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface AbuseService {

	public List<Abuse> getAll() throws DataAccessException;
	public Abuse findOne(Integer code);
	public void delete(Abuse c);
	public void save(Abuse c);
}
