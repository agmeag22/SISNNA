
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.repositories;

/**
 *
 * @author elect
 */
import java.util.List;
import java.util.Optional;
import org.glasswing.domain.Role;
import org.glasswing.domain.User;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "select count(*) from user where email= :username and password= :password and active_state=true")
    public int findOneUser(@Param("username") String username, @Param("password") String password) throws DataAccessException;

    @Query(nativeQuery = true, value = "select * from user where email= :email")
    public User findByEmail(@Param("email") String email) throws DataAccessException;

    public List<User> findByRoleNot(Role id);

    Optional<User> findByResetToken(String resetToken);
}
