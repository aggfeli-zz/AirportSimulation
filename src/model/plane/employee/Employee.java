package model.plane.employee;

import java.util.ArrayList;
import java.util.List;
//import model.plane.components.PassengerCompartment;
import model.plane.components.PlaneComponent;

/**
 *
 * @author Aggeliki Felimegka
 */

public class Employee {
    protected String name;
    protected String job;
    protected List<PlaneComponent> planeComponents = new ArrayList<PlaneComponent>();
    
    public Employee(String name, String job) 
    {
        this.name = name;
        this.job = job;
    }
    
    public void workOn(PlaneComponent planeComponent) 
    {
        planeComponents.add(planeComponent);
    }
    
    public void report() 
    {
        for (PlaneComponent planeComponent : planeComponents) 
            System.out.println(this.job + " job in " + planeComponent.getName() + " OK.");           
    } 
}
