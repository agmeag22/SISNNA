
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Country;
import org.glasswing.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public Country findOne(Integer id) {
        // TODO Auto-generated method stub

        return countryRepository.findById(id).get();
    }

    @Transactional
    public void deleteCountry(Country country) {
        countryRepository.delete(country);

    }

    @Transactional
    @Override
    public void delete(Country country) {
        countryRepository.delete(country);

    }

    @Transactional
    @Override
    public void save(Country country) {
        countryRepository.save(country);

    }

    @Override
    public List<Country> getAll() throws DataAccessException {
        return countryRepository.findAll();

    }

    @Override
    public List<Country> findNotUsedCountries() throws DataAccessException {
        return countryRepository.findNotUsedCountries();

    }
}
