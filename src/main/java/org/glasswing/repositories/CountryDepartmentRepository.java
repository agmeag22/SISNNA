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
import org.glasswing.domain.CountryDepartment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CountryDepartmentRepository extends JpaRepository<CountryDepartment, Integer>{

  
    List<CountryDepartment> findByCountry(Country c);

}