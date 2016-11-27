/**
 * 
 */
package org.sistema.hibernate.xml;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of userDAOInterface
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class PatientDAO implements PatientDAOInterface {

    private Session session;
    
	public PatientDAO () {
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
	 * selects one user by Id
	 * @param id
	 * @return User
	 */
	public Patient selectById(Long id) {
		SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Patient patient = (Patient) session.get(Patient.class, id);
	    
	    session.close();
	    return patient;
	}

	/*
	 * retrieves all users from db
	 * @return List of users
	 */
	public List<Patient> selectAll() {
	    List<Patient> patients = session.createQuery("from Patient").list();

	    return patients;
	}

	/*
	 * inserts a new user in database
	 * retrieves generated id and sets to user instance
	 * @param new user
	 */
	public void insert(Patient patient) {
	    session.beginTransaction();
	 
	    Long id = (Long) session.save(patient);
	    patient.setId(id);
	         
	    session.getTransaction().commit();
	         

	}

	/*
	 * updates user
	 * @param user to update
	 */
	public void update(Patient patient) {
		 
		    session.beginTransaction();
		 
		    session.merge(patient);
		 
		    session.getTransaction().commit();
		 
	}

	/*
	 * delete given user
	 * @param user to delete
	 */
	public void delete(Patient patient) {
	    
	    session.beginTransaction();
	    
	    session.delete(patient);
	 
	    session.getTransaction().commit();

	}

}
