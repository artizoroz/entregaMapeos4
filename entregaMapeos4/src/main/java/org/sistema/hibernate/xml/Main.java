package org.sistema.hibernate.xml;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Main class
 * @author Eugenia Pérez
 * @email eugenia_perez@cuatrovientos.org
 */
public class Main  {
	
	
	
	/**
	 * simple function for reusing
	 * @param userDAOInterface
	 */
	public static void showAllUsers (PatientDAOInterface userDAOInterface) {
		// SELECT ALL DATA
    	List<Patient> patients = userDAOInterface.selectAll();
    	String patientDesc = "";
        
    	System.out.println("\n--- Patients ----- table contents -----------");
        
        for(Patient patient : patients) {
        	patientDesc = "Id: " + patient.getId() + 
        					" - Name: " + patient.getName() + 
        					" - Doctors: " + patient.getDoctors().toString();
        	System.out.println(patientDesc);
        }

        System.out.println("Total patients: " + patients.size());	
	}
	
	/**
	 * simple function for reusing
	 * @param userDAOInterface
	 */
	public static void showAllRoles (DoctorDAOInterface doctorDAOInterface) {
		// SELECT ALL DATA
    	List<Doctor> doctors = doctorDAOInterface.selectAll();
    	String doctorDesc = "";
        
    	System.out.println("\n--- Doctors ----- table contents -----------");
        
        for(Doctor doctor : doctors) {
        	doctorDesc = "Id: " + doctor.getId() + 
        					" - Name: " + doctor.getName() +
        					" - Area: " + doctor.getArea();
        	System.out.println(doctorDesc);
        }

        System.out.println("Total doctors: " + doctors.size());	
	}
	
	
	/**
	 * main function
	 * @param args
	 */
    public static void main( String[] args )
    {

    	PatientDAOInterface patientDAO = new PatientDAO();
    	DoctorDAOInterface doctorDAO = new DoctorDAO();

    	
        // INSERT NEW DATA
    	Doctor doctor = new Doctor(0l,"default","Another doctor");
    	doctorDAO.insert(doctor);
    	HashSet<Doctor> doctors = new HashSet<Doctor>();
    	doctors.add(doctor);
    	
    	Patient newPatient = new Patient(1l,"newpatient","1234567");
    	newPatient.setDoctors(doctors);
    	
    	patientDAO.insert(newPatient);
    	
    	System.out.println("Inserted id: " + newPatient.getId());
    	
        System.out.println("\nShow data after new insert");
    	showAllUsers(patientDAO);
    	showAllRoles(doctorDAO);    	
    	
        // SELECT JUST ONE
        Patient onePatient = patientDAO.selectById(3l);
    	System.out.println("Selected Name: " + onePatient.getName());
    	
        
        // UPDATE DATA
        newPatient.setName("changed");
        patientDAO.update(newPatient);

        System.out.println("\nShow data after update");
    	showAllUsers(patientDAO);
        
        // DELETE DATA
        patientDAO.delete(newPatient);
        System.out.println("\nShow data after deletion");
    	showAllUsers(patientDAO);

    }
}
