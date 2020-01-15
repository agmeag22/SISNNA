/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.domain.Municipality;
import org.glasswing.repositories.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Override
    public Municipality findOne(Integer id) {
        // TODO Auto-generated method stub

        return municipalityRepository.findById(id).get();
    }

    @Transactional
    public void deleteMunicipality(Municipality municipality) {
        municipalityRepository.delete(municipality);

    }

    @Transactional
    @Override
    public void delete(Municipality municipality) {
        municipalityRepository.delete(municipality);

    }

    @Transactional
    @Override
    public void save(Municipality municipality) {
        municipalityRepository.save(municipality);

    }

    @Override
    public List<Municipality> getAll() throws DataAccessException {
        return municipalityRepository.findAll();

    }

    @Override
    public List<Municipality> findByCountryDepartment(CountryDepartment c) throws DataAccessException {
        return municipalityRepository.findByCountryDepartment(c);
    }

}
