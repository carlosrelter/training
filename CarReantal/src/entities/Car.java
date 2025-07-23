package entities;

public class Car {

    private String carModel;

    public Car(){
    }

    public Car(String carModel){
        this.carModel = carModel;
    }

    public void setCarModel(String carModel){
        this.carModel = carModel;
    }

    public String getCarModel(){
        return this.carModel;
    }
}
