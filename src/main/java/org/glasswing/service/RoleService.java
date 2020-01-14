/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Role;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface RoleService {

	public List<Role> getAll() throws DataAccessException;
	public Role findOne(Integer code);
	public void delete(Role c);
	public void save(Role c);
}
