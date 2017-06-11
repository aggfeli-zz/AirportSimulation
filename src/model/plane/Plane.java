package model.plane;

import java.util.Random;
import model.plane.components.CargoBay;
import model.plane.components.EquipmentCompartment;
import model.plane.components.PassengerCompartment;
import model.plane.components.PlaneComponent;
import model.plane.employee.Employee;
import model.plane.employee.MaintenanceEmployee;
import model.plane.employee.SecurityEmployee;

/**
 *@author Aggeliki Felimegka
 * 1115201300192
 */

public class Plane {
    private String description;
    private String title;
    private int capacity;
    private CargoBay cargoBay;
    private EquipmentCompartment[] equipmentCompartments;
    private PassengerCompartment[] passengerCompartments;
    
    public Plane(String description, String title, int capacity) {
        this.description = description;
        this.title = title;
        this.capacity = capacity;
        
        //Create 1 cargo bay
        this.cargoBay = new CargoBay("Cargo Bay", "This is the plane's Cargo Bay.");
        
        //Create 3  equipment compartments
        this.equipmentCompartments = new EquipmentCompartment[3];
        for (int i = 0; i < this.equipmentCompartments.length; i++) 
        {
            this.equipmentCompartments[i] = new EquipmentCompartment("Equipment Compartment " + (i + 1), "This is the plane's Equipment Compartment number " + (i + 1) + ".");
        }
        
        //Create random number of passenger compartments
        //Define if they have an internal passenger compartment randomly
        this.passengerCompartments = new PassengerCompartment[capacity / new Random().nextInt(capacity)];
        for (int i = 0; i < this.passengerCompartments.length; i++) 
        {
            this.passengerCompartments[i] = new PassengerCompartment("Passenger Compartment " + (i + 1), "This is the plane's Passenger Compartment number " + (i + 1) + ".", new Random().nextBoolean());
        }
    }
    
    public void readyCheck() {
        this.cargoBay.ready_check();
        for (int i = 0; i < this.equipmentCompartments.length; i++) 
        {
            this.equipmentCompartments[i].ready_check();
        }
        for (int i = 0; i < this.passengerCompartments.length; i++) 
        {
            this.passengerCompartments[i].ready_check();
        }
        System.out.println("Plane ready to take off!");
    }
    
    public void process(Employee employee) //Assigns jobs to employees
    {
        if (employee instanceof SecurityEmployee) //Employee works in every compartment
        {
            assignCompartmentToEmployee(employee, this.cargoBay);
            assignCompartmentsToEmployee(employee, this.equipmentCompartments);
            assignCompartmentsToEmployee(employee, this.passengerCompartments);
        } 
        else if (employee instanceof MaintenanceEmployee) //Employee works in equipmentCompartments and cargoBay
        {
            assignCompartmentToEmployee(employee, this.cargoBay);
            assignCompartmentsToEmployee(employee, this.equipmentCompartments);
        } 
        else            //Cleaning employee works in passengerCompartments and equipmentCompartments
        {
            assignCompartmentsToEmployee(employee, this.equipmentCompartments);
            assignCompartmentsToEmployee(employee, this.passengerCompartments);
        }
    }
    
    private void assignCompartmentsToEmployee(Employee employee, PlaneComponent[] planeComponents)
    {
        for (int i = 0; i < planeComponents.length; i++) 
            assignCompartmentToEmployee(employee, planeComponents[i]);
    }
    
    private void assignCompartmentToEmployee(Employee employee, PlaneComponent planeComponent) 
    {
        employee.workOn(planeComponent);
        if (planeComponent instanceof PassengerCompartment) 
        {
            if (((PassengerCompartment)planeComponent).getInternalPassengerCompartment() != null) 
                employee.workOn(((PassengerCompartment)planeComponent).getInternalPassengerCompartment());
        }
        if (planeComponent instanceof CargoBay) 
        {
            if (((CargoBay)planeComponent).getEquipmentCompartment() != null) 
                employee.workOn(((CargoBay)planeComponent).getEquipmentCompartment());
        }
    }
}
