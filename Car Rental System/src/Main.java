import Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


    public List<User> addUsers() {
        User user1 = new User();
        user1.setName("User1");
        user1.setId(1);

        User user2 = new User();
        user2.setName("User2");
        user2.setId(2);
        return new ArrayList<>(Arrays.asList(user1, user2));
    }

    public List<Vehicle> getVehicles() {
        VehicleInventoryManagement vehicleInventoryManagement = new VehicleInventoryManagement();
        Vehicle vehicle1 = new Vehicle(1, VehicleType.CAR);

        Vehicle vehicle2 = new Vehicle(2, VehicleType.BIKE);
        return new ArrayList<>(Arrays.asList(vehicle1, vehicle2));
    }

    public List<Store> addStores(List<Vehicle> vehicles) {
        Store store1 = new Store();
        VehicleInventoryManagement vehicleInventoryManagement = new VehicleInventoryManagement();
        vehicleInventoryManagement.addVehicles(vehicles);
        store1.setVehicleInventoryManagement(vehicleInventoryManagement);
        return new ArrayList<>(Arrays.asList(store1));
    }
}