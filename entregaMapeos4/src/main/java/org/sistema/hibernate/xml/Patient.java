/**
 * 
 */
package org.sistema.hibernate.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents system User data
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Patient {
	private Long id;
	private String name;
	private String sex;
    private Set<Doctor> doctors;
	
	/**
	 * default constructor
	 */
	public Patient () {
		
	}
	
	/**
	 * Constructor with all attributes
	 * @param id
	 * @param name
	 * @param sex
	 * @param email
	 */
	public Patient(Long id, String name, String sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.doctors = new HashSet<Doctor>();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the password to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the roles
	 */
	public Set<Doctor> getDoctors() {
		return doctors;
	}

	/**
	 * @param doctors the roles to set
	 */
	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	
}
