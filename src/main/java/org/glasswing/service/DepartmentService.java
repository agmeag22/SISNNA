/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Department;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface DepartmentService {

	public List<Department> getAll() throws DataAccessException;
	public Department findOne(Integer code);
	public void delete(Department c);
	public void save(Department c);
}
