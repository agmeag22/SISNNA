/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Program;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface ProgramService {

	public List<Program> getAll() throws DataAccessException;
	public Program findOne(Integer code);
	public void delete(Program c);
	public void save(Program c);
}
