import java.util.List;
import java.util.Scanner;

public class Main {
    static Station dumpMore = new Station("Dump More");
    static Output output = new Output();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        boolean quit = false;


        //Adds the unloading places
        dumpMore.addUnloadingPlace('A');
        dumpMore.addUnloadingPlace('B');
        dumpMore.addUnloadingPlace('C');
        dumpMore.addUnloadingPlace('D');
        dumpMore.addUnloadingPlace('E');

        //Keeps the menu going
        while(!quit){
            output.printFirstMenu();
            output.printChooseFromList();
            String input = scanner.next();

            //See trucks
            if (input.equals("1")){
                output.printTrucks(dumpMore.getUnloadingPlaces());
            }

            //Add trucks
            else if (input.equals("2")){
                output.printChooseTruckMenu();
                output.printChooseFromList();
                input = scanner.next();
                setTrucks(input);
            }

            //Quit
            else if (input.equals("3")){
                quit = true;
            }
        }
    }

    //Set the trucks in unloadingPlace
    public static void setTrucks(String input){
        List<UnloadingPlace> unloadingPlace = dumpMore.getUnloadingPlaces();
        output.printSetWeight();
        int weight = scanner.nextInt();
        //Add Van
        if (input.equals("1")){
            //If unloading place A is available
            if (unloadingPlace.get(0).isAvailable())
            {
                dumpMore.setVehicle(new Van(weight), 'A');
                output.printTruckAdded('A');
            }
            //If unloading place B is available
            else if (unloadingPlace.get(1).isAvailable()) {
                dumpMore.setVehicle(new Van(weight), 'B');
                output.printTruckAdded('B');
            }
            else {
                output.printStationFull();
            }
        }
        //Add Small Truck
        else if (input.equals("2")) {
            //If unloading place A is available and under 5 ton
            if (weight < 5000 && unloadingPlace.get(0).isAvailable()){
                dumpMore.setVehicle(new SmallTruck(weight), 'A');
                output.printTruckAdded('A');
            }
            //If unloading place C is available
            else if(unloadingPlace.get(2).isAvailable())
            {
                dumpMore.setVehicle(new SmallTruck(weight), 'C');
                output.printTruckAdded('C');
            }
            //If unloading place D is available
            else if(unloadingPlace.get(3).isAvailable()){
                dumpMore.setVehicle(new SmallTruck(weight), 'D');
                output.printTruckAdded('D');
            }
            else
            {
                output.printStationFull();
            }

        }

        //Add Heavy Truck
        else if(input.equals("3"))
        {
            //If unloading place D is available and under 9 ton
            if (weight < 9000 && unloadingPlace.get(3).isAvailable()){
                dumpMore.setVehicle(new HeavyTruck(weight), 'D');
                output.printTruckAdded('D');
            }
            //If unloading place E is available
            else if(unloadingPlace.get(4).isAvailable())
            {
                dumpMore.setVehicle(new HeavyTruck(weight), 'E');
                output.printTruckAdded('E');
            }
            else
            {
                output.printStationFull();
            }
        }
    }
}