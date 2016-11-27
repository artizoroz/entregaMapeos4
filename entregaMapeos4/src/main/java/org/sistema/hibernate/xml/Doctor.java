/**
 * 
 */
package org.sistema.hibernate.xml;

import java.util.HashSet;
import java.util.Set;
/**
 * Represents system User role data
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Doctor {
	private Long id;
	private String name;
	private String area;
    private Set<Patient> patients;
    
	/**
	 * default constructor
	 */
	public Doctor () {
		
	}
	
	/**
	 * Constructor with all attributes
	 * @param id
	 * @param name
	 * @param area
	 */
	public Doctor(Long id, String name, String area) {
		this.id = id;
		this.name = name;
		this.area = area;
		this.patients  = new HashSet<Patient>();
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
	 * @return the description
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the description to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the users
	 */
	public Set<Patient> getPatients() {
		return patients;
	}

	/**
	 * @param patients the users to set
	 */
	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	
	
}
