/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Role;
import org.glasswing.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository RoleRepository;

    @Override
    public Role findOne(Integer id) {
        // TODO Auto-generated method stub
        return RoleRepository.findById(id).get();
    }

    @Transactional
    public void deleteRole(Role role) {
        RoleRepository.delete(role);

    }

    @Transactional
    @Override
    public void delete(Role role) {
        RoleRepository.delete(role);

    }

    @Transactional
    @Override
    public void save(Role role) {
        RoleRepository.save(role);

    }

    @Override
    public List<Role> getAll() throws DataAccessException {
        return RoleRepository.findAll();
    }
}
