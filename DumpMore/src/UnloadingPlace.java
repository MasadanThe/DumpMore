public class UnloadingPlace {
    private char name;
    private Vehicle vehicle;

    private boolean available;

    public UnloadingPlace(){
        name = 'A';
        available = true;
    }
    public UnloadingPlace(char name){
        this.name = name;
        available = true;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setVehicle(Vehicle vehicle){
        if(available){
            this.vehicle = vehicle;
            available = false;
        }
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public boolean isAvailable(){
        return available;
    }
}
