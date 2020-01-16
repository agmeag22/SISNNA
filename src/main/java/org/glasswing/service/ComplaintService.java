/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Complaint;
import org.glasswing.domain.State;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface ComplaintService {

	public List<Complaint> getAll() throws DataAccessException;
        public List<Complaint> findByStateNot(State s) throws DataAccessException;
        public List<Complaint> findByState(State s) throws DataAccessException;
	public Complaint findOne(Integer code);
	public void delete(Complaint c);
	public void save(Complaint c);
}
