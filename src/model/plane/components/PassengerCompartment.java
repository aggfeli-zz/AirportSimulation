package model.plane.components;

/**
 *
 * @author Aggeliki Felimegka
 */

public class PassengerCompartment extends PlaneComponent {
    protected PassengerCompartment internalPassengerCompartment;
    
    public PassengerCompartment(String name, String description, boolean hasInternalCompartment) 
    {
        super(name, description);
        if (hasInternalCompartment == true) 
        {
            this.internalPassengerCompartment = new PassengerCompartment( "Internal Passenger Compartment within " + name, "This is the plane's Internal Passenger Compartment " + name + ".", false);
        }
    }
    
    public PassengerCompartment getInternalPassengerCompartment() 
    {
        return internalPassengerCompartment;
    }
   
    @Override
    public void ready_check() 
    {
        super.ready_check();
        if (this.internalPassengerCompartment != null)         
            this.internalPassengerCompartment.ready_check();
        
    }
}
