/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Department;
import org.glasswing.domain.DepartmentPositions;
import org.glasswing.repositories.DepartmentPositionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentPositionsServiceImpl implements DepartmentPositionsService {

    @Autowired
    DepartmentPositionsRepository DepartmentPositionsRepository;

    @Override
    public DepartmentPositions findOne(Integer id) {
        // TODO Auto-generated method stub
        return DepartmentPositionsRepository.findById(id).get();
    }

    @Transactional
    public void deleteDepartmentPositions(DepartmentPositions DepartmentPositions) {
        DepartmentPositionsRepository.delete(DepartmentPositions);

    }

    @Transactional
    @Override
    public void delete(DepartmentPositions DepartmentPositions) {
        DepartmentPositionsRepository.delete(DepartmentPositions);

    }

    @Transactional
    @Override
    public void save(DepartmentPositions DepartmentPositions) {
        DepartmentPositionsRepository.save(DepartmentPositions);

    }

    @Override
    public List<DepartmentPositions> getAll() throws DataAccessException {
        return DepartmentPositionsRepository.findAll();
    }

    @Override
    public List<DepartmentPositions> findAllbyDepartment(Department iddepartment) {
       return DepartmentPositionsRepository.findByDepartment(iddepartment);
    }
}
