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
import org.glasswing.domain.DepartmentPositions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentPositionsRepository extends JpaRepository<DepartmentPositions, Integer> {

    @Query("select c from Department_Positions c WHERE c.id_department= :iddepartment")
    List<DepartmentPositions> findAllforDepartmentId(@Param("iddepartmpent") int iddepartment);

}
