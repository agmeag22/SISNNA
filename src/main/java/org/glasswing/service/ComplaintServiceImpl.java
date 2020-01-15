/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Complaint;
import org.glasswing.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Override
    public Complaint findOne(Integer id) {
        // TODO Auto-generated method stub
        return complaintRepository.findById(id).get();
    }

    @Transactional
    public void deleteComplaint(Complaint complaint) {
        complaintRepository.delete(complaint);

    }

    @Transactional
    @Override
    public void delete(Complaint complaint) {
        complaintRepository.delete(complaint);

    }

    @Transactional
    @Override
    public void save(Complaint complaint) {
        complaintRepository.save(complaint);

    }

    @Override
    public List<Complaint> getAll() throws DataAccessException {
        return complaintRepository.findAll();
    }
}
