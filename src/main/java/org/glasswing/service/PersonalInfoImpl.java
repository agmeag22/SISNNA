/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Role;
import org.glasswing.domain.PersonalInfo;
import org.glasswing.repositories.PersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoImpl implements PersonalInfoService {

    @Autowired
    PersonalInfoRepository personalInfoRepository;

    @Override
    public PersonalInfo findOne(Integer id) {
        // TODO Auto-generated method stub
        return personalInfoRepository.findById(id).get();
    }

    @Override
    public List<PersonalInfo> getAll() {
        return personalInfoRepository.findAll();
    }
}
