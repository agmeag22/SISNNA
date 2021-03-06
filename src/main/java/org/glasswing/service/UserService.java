/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import java.util.Optional;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface UserService {
        public List<User> getAll();
	public boolean findOneUser(String username, String password) throws DataAccessException;
         public List<User> findByIdRoleNot(Role id) throws DataAccessException;
         public User findByEmail(String email) throws DataAccessException;
	public User findOne(Integer code);
	public void delete(User user);
	public void save(User user);
        public Optional<User> findUserByResetToken(String resetToken);
}
