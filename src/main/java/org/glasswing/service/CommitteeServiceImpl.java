/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Committee;
import org.glasswing.repositories.CommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommitteeServiceImpl implements CommitteeService {

    @Autowired
    CommitteeRepository committeeRepository;

    @Override
    public Committee findOne(Integer id) {
        // TODO Auto-generated method stub
        return committeeRepository.findById(id).get();
    }

    @Transactional
    public void deleteCommittee(Committee committee) {
        committeeRepository.delete(committee);

    }

    @Transactional
    @Override
    public void delete(Committee committee) {
        committeeRepository.delete(committee);

    }

    @Transactional
    @Override
    public void save(Committee committee) {
        committeeRepository.save(committee);

    }

    @Override
    public List<Committee> getAll() throws DataAccessException {
        return committeeRepository.findAll();
    }
}
