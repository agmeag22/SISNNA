/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glasswing.service;

import java.util.List;
import org.glasswing.domain.Position;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author elect
 */

public interface PositionService {

	public List<Position> getAll() throws DataAccessException;
	public Position findOne(Integer code);
	public void delete(Position c);
	public void save(Position c);
        public boolean findOneBoolean(int idposition);
}
