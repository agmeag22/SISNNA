/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.domain.CountryDepartment;
import org.glasswing.repositories.CountryDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryDepartmentServiceImpl implements CountryDepartmentService {

    @Autowired
    CountryDepartmentRepository countryRepository;

    @Override
    public CountryDepartment findOne(Integer id) {
        // TODO Auto-generated method stub

        return countryRepository.findById(id).get();
    }

    public void deleteCountryDepartment(CountryDepartment country) {
        countryRepository.delete(country);

    }

    @Transactional
    @Override
    public void delete(CountryDepartment country) {
        countryRepository.delete(country);

    }

    @Transactional
    @Override
    public void save(CountryDepartment country) {
        countryRepository.save(country);

    }

    @Override
    public List<CountryDepartment> getAll() throws DataAccessException {
        return countryRepository.findAll();

    }

    @Override
    public List<CountryDepartment> findByCountry(Country c) throws DataAccessException {
        return countryRepository.findByCountry(c);

    }

}
