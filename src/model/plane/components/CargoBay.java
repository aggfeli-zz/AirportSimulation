package model.plane.components;

/**
 *
 * @author Aggeliki Felimegka
 */
public class CargoBay extends PrivateCompartment {   
    private EquipmentCompartment equipmentCompartment;
    
    public CargoBay(String name, String description) 
    {
        super(name, description);
        this.equipmentCompartment = new EquipmentCompartment("Equipement Compartment within " + name, "This is the plane's Equipement Compartment within " + name + ".");
    }
    
    @Override
    public void ready_check() 
    {
        super.ready_check();
        this.equipmentCompartment.ready_check();   
    }
    
    public EquipmentCompartment getEquipmentCompartment() 
    {
        return equipmentCompartment;
    }
}
