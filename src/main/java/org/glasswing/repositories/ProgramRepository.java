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
import org.glasswing.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProgramRepository extends JpaRepository<Program, Integer>{

}