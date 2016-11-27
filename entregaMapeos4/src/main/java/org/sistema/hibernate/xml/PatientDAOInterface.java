package org.sistema.hibernate.xml;

import java.util.List;

/**
 * interface for UserDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface PatientDAOInterface {
	
	public Patient selectById(Long id);
	public List<Patient> selectAll ();
	public void insert (Patient patient);
	public void update (Patient patient);
	public void delete (Patient patient);

}
