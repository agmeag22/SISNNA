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
import org.glasswing.domain.Complaint;
import org.glasswing.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ComplaintRepository extends JpaRepository<Complaint, Integer>{
        List<Complaint> findByStateNot(State s);
        List<Complaint> findByState(State s);
}