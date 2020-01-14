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
import org.glasswing.domain.Country;
import org.glasswing.domain.User;



import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface CountryRepository extends JpaRepository<Country, Integer>{

    @Query("select c from Country c WHERE c.idCountry NOT IN(SELECT co.country FROM Committee co)")
    List<Country> findNotUsedCountries();

}