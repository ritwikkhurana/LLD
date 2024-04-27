package Model;

import javax.xml.crypto.Data;

public class Vehicle {
    int id;
    VehicleType vehicleType;
    int hourlyCost;
    int dailyCost;
    Data manufactureDate;
    String modelName;
    int chasisNo;

    public Vehicle(int id, VehicleType vehicleType) {
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getHourlyCost() {
        return hourlyCost;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public Data getManufactureDate() {
        return manufactureDate;
    }

    public String getModelName() {
        return modelName;
    }

    public int getChasisNo() {
        return chasisNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setHourlyCost(int hourlyCost) {
        this.hourlyCost = hourlyCost;
    }

    public void setDailyCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    public void setManufactureDate(Data manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setChasisNo(int chasisNo) {
        this.chasisNo = chasisNo;
    }
}
