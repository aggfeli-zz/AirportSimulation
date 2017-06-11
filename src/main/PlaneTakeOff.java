/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.plane.employee.CleaningEmployee;
import model.plane.employee.MaintenanceEmployee;
import model.plane.employee.SecurityEmployee;
import model.plane.Plane;

/**
 *
 * @author Aggeliki Felimegka
 */

public class PlaneTakeOff {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Plane plane = new Plane("This is a demo plane", "Aggeliki's Plane", 300);
        
        SecurityEmployee securityEmployee = new SecurityEmployee("Security Employee");
        MaintenanceEmployee maintenanceEmployee = new MaintenanceEmployee("Maintenance Employee");
        CleaningEmployee cleaningEmployee = new CleaningEmployee("Cleaning Employee");
        
        plane.process(securityEmployee);
        plane.process(maintenanceEmployee);
        plane.process(cleaningEmployee);
        
        securityEmployee.report();
        maintenanceEmployee.report();
        cleaningEmployee.report();
        
        plane.readyCheck();
        
    }
}
