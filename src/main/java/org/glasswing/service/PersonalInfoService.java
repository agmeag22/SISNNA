/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.PersonalInfo;
import org.glasswing.repositories.PersonalInfoRepository;

/**
 *
 * @author elect
 */

public interface PersonalInfoService {
	public List<PersonalInfo> getAll();
	public PersonalInfo findOne(Integer code);
}
