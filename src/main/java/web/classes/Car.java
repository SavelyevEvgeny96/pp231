package web.classes;


public class Car {
    private String manufacturer;
    private String model;
    private int earRelease;

    public Car(String manufacturer, String model, int earRelease) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.earRelease = earRelease;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getEarRelease() {
        return earRelease;
    }

    public void setEarRelease(int earRelease) {
        this.earRelease = earRelease;
    }
}