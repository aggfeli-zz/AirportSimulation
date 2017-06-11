package model.plane.components;

import model.plane.employee.Employee;

/**
 *
 * @author Aggeliki Felimegka
 */
public class PlaneComponent extends Object {
   protected String description = "Plane Component Description";
   protected String name = "Plane Component";
   protected Employee employee;
   
   protected PlaneComponent(String name, String description) 
   {
       this.name = name;
       this.description = description;
   }
   
   public void ready_check() 
   {
       System.out.println(this.description);
       System.out.println(this.name + " OK!");
   }
   
   public void process(Employee employee) 
   {
       this.employee = employee;
   }
   
   public String getName() 
   {
       return this.name;
   }
}
