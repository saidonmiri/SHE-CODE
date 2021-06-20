package com.company.Demo.Garage;

import javax.xml.bind.annotation.*;
import java.util.*;


@XmlRootElement(name="garage")
@XmlAccessorType(XmlAccessType.FIELD)
public class GarageManager {

    @XmlElements({
            @XmlElement(type=Car.class),
            @XmlElement(type=Truck.class),
            @XmlElement(type=Motorcycle.class)
    })
    static HashMap<String, Vehicle> vehicles;
    private Integer profit;
    static VehicleStatus vehicleStatus;

    public GarageManager() {
        vehicles = new HashMap<String, Vehicle>();
    }


    public void startGarageManagement() {
        Scanner console = new Scanner(System.in);

        while (true) {

            printMainMenu();
            Integer selectedOption = console.nextInt();

            switch (selectedOption) {
                case 1: //add new Vehicle
                    addNewVehicle();
                    break;
                case 2:
                    // Change status of a vehicle based on the license plate number
                    changeVehicleStatus();
                    break;
                case 3:
                    // Get vehicle details based on specific license plate number.
                    getVehicleDetails();
                    break;
                case 4:
                    // Get list of vehicles currently in the garage based on status (not including “Released”).
                    showVehiclesListByStatus();
                    break;
                case 5:
                    //Get list of vehicles based on search keyword (searching the description).
                    getVehicleDetailsByKeyword();
                    break;
                case 6:
                    //Get list of vehicles sorted by year of manufacturing
                    getSortedListByYear();
                    break;
                case 7:
                    // Get the total profit of vehicles that were already released
                     getTotalProfit();
                    break;
                case 8:
                    // Exit
                    break;
                default:
                    System.exit(0);
            }
        }

    }

    private void printMainMenu() {
        System.out.println();
        System.out.println();
        System.out.println("1. Insert a new vehicle");
        System.out.println("2. Change status of a vehicle");
        System.out.println("3. Get vehicle details");
        System.out.println("4. Get list of vehicles currently in the garage");
        System.out.println("5. Get list of vehicles based on search keyword (Description)");
        System.out.println("6. Get list of vehicles sorted by year");
        System.out.println("7. Get the total profit of vehicles ");
        System.out.println("8. Exit");
        System.out.println();
    }

    private boolean addNewVehicle() {
        Vehicle vehicle;
        Scanner console = new Scanner(System.in);

        System.out.println("Vehicle type?");
        System.out.println("( 1. Car  2. Truck  3. Motorcycle )");
        int newTypeNumber = -1;
        if (console.hasNextInt())
            newTypeNumber = console.nextInt();
        else {
            System.out.println("Invalid vehicle type. Aborting...");
            return false;
        }
        vehicle = VehicleFactory.createVehicle(newTypeNumber);

        if (vehicle == null) {
            System.out.println("Invalid vehicle type. Aborting...");
            return false;
        }

        vehicle.getVehicleDetails();
        if (vehicles.containsKey(vehicle.getLicensePlate())) {
            System.out.println("Vehicle already exist. Aborting...");
            return false;
        }

        vehicle.setType(vehicle.getClass().getSimpleName());
        vehicle.setStatus(VehicleStatus.NEW);


        vehicles.put(vehicle.getLicensePlate(), vehicle);
        SerializationService.getInstance().serializeGarage(this);

        // System.out.println(vehicles.get(licensePlate).toString());
        return true;
    }

    private void changeVehicleStatus() {
        //get specific Vehicle
        Vehicle vehicle = getVehicleByLicensePlate();

        Scanner console = new Scanner(System.in);
        System.out.println("Select the current status:");
        System.out.println("1. In progress");
        System.out.println("2. Fixed");
        System.out.println("3. Released");
        Integer vehicleStatusNumber = console.nextInt();

        switch (vehicleStatusNumber) {
            case 1:
                vehicle.setStatus(VehicleStatus.IN_PROCESS);
                break;
            case 2:
                vehicle.setStatus(VehicleStatus.FIXED);
                break;
            case 3:
                vehicle.setStatus(VehicleStatus.RELEASED);
                // profit calculation
                profit = +vehicle.getPrice();
                System.out.println("Current Profit is : " + profit);
                //delete from HashMap
                vehicles.remove(vehicle.getLicensePlate());
                SerializationService.getInstance().serializeGarage(this);
                break;
            default:
                System.out.println("Invalid Status. Aborting...");
                break;
        }
        SerializationService.getInstance().serializeGarage(this);
        System.out.println("Status changed successfully");
    }

    private Vehicle getVehicleByLicensePlate() {
        System.out.println("Enter vehicle license plate?");
        Scanner console = new Scanner(System.in);

        if (console.hasNext()) {
            String licensePlate = console.next();
            if (vehicles.containsKey(licensePlate)) {
                return vehicles.get(licensePlate);
            } else {
                System.out.println("Invalid license plate. Aborting...");
                return null;
            }
        }
        System.out.println("Invalid input. Aborting...");
        return null;
    }


    private boolean getVehicleDetails() {
        Vehicle vehicle = getVehicleByLicensePlate();
        if (vehicle == null)
            return false;
        vehicle.printVehicleDetails();
        return true;
    }

    private boolean showVehiclesListByStatus() {
        System.out.println("Select the status:");
        System.out.println("1. New");
        System.out.println("2. In progress");
        System.out.println("3. Fixed");
        Scanner console = new Scanner(System.in);

        Integer vehicleStatusNumber = -1;
        if (console.hasNextInt())
            vehicleStatusNumber = console.nextInt();
        else {
            System.out.println("Invalid Status. Aborting...");
            return false;
        }
        switch (vehicleStatusNumber) {
            case 1:
                vehicleStatus = VehicleStatus.NEW;
                break;
            case 2:
                vehicleStatus = VehicleStatus.IN_PROCESS;
                break;
            case 3:
                vehicleStatus = VehicleStatus.FIXED;
                break;
            default:
                System.out.println("Invalid Status. Aborting...");
                return false;
        }

        for (Vehicle vehicleByStatus : vehicles.values()) {
            if (vehicleByStatus.getStatus() == vehicleStatus)
                vehicleByStatus.printVehicleDetails();
        }
        return true;
    }

    private boolean getVehicleDetailsByKeyword() {
        System.out.println("Enter the keyword to search:");
        Scanner console = new Scanner(System.in);

        String vehicleKeyword = "";
        if (console.hasNext()) {
            vehicleKeyword = console.next();
            for (Vehicle vehicleByKeyword : vehicles.values()) {
                if (vehicleByKeyword.getProblemDescription().contains(vehicleKeyword))
                    vehicleByKeyword.printVehicleDetails();
            }
            return true;
        }
        else {
            System.out.println("Invalid Keyword. Aborting...");
            return false;
        }
    }



    private void getSortedListByYear() {

//        Sorting LinkedList with Collections.sort() method in natural order
//        List<Vehicle> vehiclesList = new LinkedList<>( vehicles.values());
//        vehiclesList.sort(Comparator.reverseOrder());

//
//        List<Vehicle> vehiclesList = new LinkedList<Vehicle>(vehicles.values());
//        Collections.sort(vehiclesList);

//        Sorting LinkedList using Collection.sort() and Comparator in Java - require  @Override on method compare
        List<Vehicle> vehiclesList = new LinkedList<Vehicle>(vehicles.values());
        Collections.sort(vehiclesList, Vehicle.Comparators.ManufacturingYear);
        for (Vehicle vehicle : vehiclesList) {
            vehicle.printVehicleDetails();
        }
    }

    private void getTotalProfit()
    {
        System.out.println("Current Profit is : " + profit);
    }

}
