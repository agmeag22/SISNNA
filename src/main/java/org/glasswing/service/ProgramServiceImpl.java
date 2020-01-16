/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Program;
import org.glasswing.repositories.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    ProgramRepository programRepository;

    @Override
    public Program findOne(Integer id) {
        // TODO Auto-generated method stub
        return programRepository.findById(id).get();
    }

    @Transactional
    public void deleteProgram(Program program) {
        programRepository.delete(program);

    }

    @Transactional
    @Override
    public void delete(Program program) {
        programRepository.delete(program);

    }

    @Transactional
    @Override
    public void save(Program program) {
        programRepository.save(program);

    }

    @Override
    public List<Program> getAll() throws DataAccessException {
        return programRepository.findAll();
    }
}
