package Model;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventoryManagement {
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    List<Vehicle> vehicleList;

    public VehicleInventoryManagement(){
        vehicleList = new ArrayList<>();
    }

    public void addVehicles(List<Vehicle> vehicles) {
        this.vehicleList.addAll(vehicles);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.vehicleList.remove(vehicle);
    }
}
