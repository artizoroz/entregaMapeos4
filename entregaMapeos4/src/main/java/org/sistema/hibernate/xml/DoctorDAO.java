/**
 * 
 */
package org.sistema.hibernate.xml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of roleDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class DoctorDAO implements DoctorDAOInterface {

    private Session session;
    
    /**
     * default constructor, inits hibernate session
     */
	public DoctorDAO () {
		session = HibernateSession.getSession();
	}
	
	/**
	 * @return the session
	 */
	public Session getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(Session session) {
		this.session = session;
	}
	
	/* 
	 * selects one role by Id
	 * @param id
	 * @return Role
	 */
	public Doctor selectById(Long id) {
	 
	    Doctor doctor = (Doctor) session.get(Doctor.class, id);

	    return doctor;
	}

	/*
	 * retrieves all roles from db
	 * @return List of roles
	 */
	public List<Doctor> selectAll() {
 
	    List<Doctor> doctors = session.createQuery("from Doctor").list();

	    return doctors;
	}

	/*
	 * inserts a new role in database
	 * retrieves generated id and sets to role instance
	 * @param new role
	 */
	public void insert(Doctor doctor) {

	    session.beginTransaction();
	 
	    Long id = (Long) session.save(doctor);
	    doctor.setId(id);
	         
	    session.getTransaction().commit();

	}

	/*
	 * updates role
	 * @param role to update
	 */
	public void update(Doctor doctor) {
		 
		    session.beginTransaction();
		 
		    session.merge(doctor);
		 
		    session.getTransaction().commit();
		 
	}

	/*
	 * delete given role
	 * @param role to delete
	 */
	public void delete(Doctor doctor) {
	    
	    session.beginTransaction();
	    
	    session.delete(doctor);
	 
	    session.getTransaction().commit();

	}

}
