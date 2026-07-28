package designpattern;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving Car");
    }
}

class Bike implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving Bike");
    }
}

class VehicleFactory {

    public static Vehicle getVehicle(String vehicleType) {

        if (vehicleType.equalsIgnoreCase("car")) {
            return new Car();
        }

        if (vehicleType.equalsIgnoreCase("bike")) {
            return new Bike();
        }

        throw new IllegalArgumentException("Invalid Vehicle Type");
    }
}

public class Factory {

    public static void main(String[] args) {

    	String vehicleType  = "car";  // Client's input
        Vehicle vehicle = VehicleFactory.getVehicle(vehicleType);
        vehicle.drive();
    }
}