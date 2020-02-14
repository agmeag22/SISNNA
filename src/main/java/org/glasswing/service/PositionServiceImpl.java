/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Position;
import org.glasswing.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository PositionRepository;

    @Override
    public Position findOne(Integer id) {
        // TODO Auto-generated method stub
        return PositionRepository.findById(id).get();
    }

    @Transactional
    public void deletePosition(Position Position) {
        PositionRepository.delete(Position);

    }

    @Transactional
    @Override
    public void delete(Position Position) {
        PositionRepository.delete(Position);

    }

    @Transactional
    @Override
    public void save(Position Position) {
        PositionRepository.save(Position);

    }

    @Override
    public List<Position> getAll() throws DataAccessException {
        return PositionRepository.findAll();
    }

    @Override
    public boolean findOneBoolean(int idposition) {
        if(PositionRepository.exists(idposition)>0){
        return true;    
        }
        return false;
    }
}
