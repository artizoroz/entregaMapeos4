package org.sistema.hibernate.xml;

import java.util.List;

/**
 * interface for RoleDAO class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public interface DoctorDAOInterface {
	
	public Doctor selectById(Long id);
	public List<Doctor> selectAll ();
	public void insert (Doctor doctor);
	public void update (Doctor doctor);
	public void delete (Doctor doctor);

}
