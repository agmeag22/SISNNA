/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Department;
import org.glasswing.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department findOne(Integer id) {
        // TODO Auto-generated method stub
        return departmentRepository.findById(id).get();
    }

    @Transactional
    public void deleteDepartment(Department department) {
        departmentRepository.delete(department);

    }

    @Transactional
    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);

    }

    @Transactional
    @Override
    public void save(Department department) {
        departmentRepository.save(department);

    }

    @Override
    public List<Department> getAll() throws DataAccessException {
        return departmentRepository.findAll();
    }
}
