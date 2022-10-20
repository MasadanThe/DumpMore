import java.util.List;

public class Output {

    public Output(){

    }

    public void printFirstMenu(){
        System.out.println("- Unloading station Dump More -");
        System.out.println("1. See parked trucks");
        System.out.println("2. Register new unloading of truck");
        System.out.println("3. Quit");
    }

    public void printChooseTruckMenu(){
        System.out.println("Type of truck:");
        System.out.println("1. Van");
        System.out.println("2. Small truck");
        System.out.println("3. Heavy truck");
    }

    //Gets all unloading places and prints out their information if the vehicle exists
    public void printTrucks(List<UnloadingPlace> unloadingPlaces){
        if(unloadingPlaces.size() > 0) {
            for (int i = 0; i < unloadingPlaces.size(); i++) {
                if(unloadingPlaces.get(i).getVehicle() != null) {
                    char unloadingPlaceName = unloadingPlaces.get(i).getName();
                    String vehicleName = unloadingPlaces.get(i).getVehicle().getName();
                    int vehicleWeight = unloadingPlaces.get(i).getVehicle().getWeight();
                    System.out.println(unloadingPlaceName + " - " + vehicleName + " [" + vehicleWeight + "kg]");
                }
            }
        }

    }

    public void printSetWeight(){
        System.out.println("Weight of truck: ");
    }

    public void printTruckAdded(char unloadingSymbol){
        System.out.println("Truck registered for unloading place " + unloadingSymbol);
    }

    public void printStationFull(){
        System.out.println("Unfortunately the station is full, driver can go to Dump Most");
    }

    public void printChooseFromList(){
        System.out.println("Choose from list: ");
    }
}
