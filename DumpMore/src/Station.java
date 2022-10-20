import java.util.ArrayList;
import java.util.List;

public class Station {

    private String name;
    private List<UnloadingPlace> unloadingPlaces;

    public Station(){
        name = "Station";
        unloadingPlaces = new ArrayList<>();
    }

    public Station(String name){
        this.name = name;
        unloadingPlaces = new ArrayList<>();
    }

    public void addUnloadingPlace(char unloadingSymbol){
        unloadingPlaces.add(new UnloadingPlace(unloadingSymbol));
    }

    //Loops through the list and finds the right UnloadingPlace
    public void setVehicle(Vehicle vehicle, char unloadingSymbol){
        for (int i = 0; i < unloadingPlaces.size(); i++)
        {
            if(unloadingPlaces.get(i).getName() == unloadingSymbol)
            {
                unloadingPlaces.get(i).setVehicle(vehicle);
            }
        }
    }

    public List<UnloadingPlace> getUnloadingPlaces(){
        return unloadingPlaces;
    }
}
