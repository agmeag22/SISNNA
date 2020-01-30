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
import org.glasswing.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface PositionRepository extends JpaRepository<Position, Integer>{

    @Query("select count(*) from Position WHERE id_position= :idposition")
    int exists(@Param("idposition") int idposition);

}