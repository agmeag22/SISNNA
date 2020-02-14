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
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MunicipalityRepository extends JpaRepository<Municipality, Integer>{

    List<Municipality> findByCountryDepartment(CountryDepartment c);

}