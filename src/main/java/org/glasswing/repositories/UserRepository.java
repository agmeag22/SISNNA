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
import org.glasswing.domain.User;



import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery=true, value="select count(*) from public.table_user where username= :username and pass= :password")
	public int findOneUser(@Param("username")String username,@Param("password") String password) throws DataAccessException ;


//	@Query(nativeQuery=true, value="select * from table_user where id_store=:code")
//	public List<User> findBySucursal(@Param("code") int code) throws DataAccessException ;
}