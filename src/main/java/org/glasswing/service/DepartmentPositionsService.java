/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Department;
import org.glasswing.domain.DepartmentPositions;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface DepartmentPositionsService {

	public List<DepartmentPositions> getAll() throws DataAccessException;
        
	public DepartmentPositions findOne(Integer code);
	public void delete(DepartmentPositions c);
	public void save(DepartmentPositions c);
        public  List<DepartmentPositions> findAllbyDepartment(Department iddepartment);
}
