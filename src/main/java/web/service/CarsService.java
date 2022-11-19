package web.service;


import web.classes.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsService {
    private static List<Car> carsList(){
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Citroen", "c4", 2007));
        cars.add(new Car("LADA", "Largus", 2010));
        cars.add(new Car("UAZ", "Patriot", 3163));
        cars.add(new Car("Audi", "A6", 1999));
        cars.add(new Car("Mitsubishi", "Charisma", 2002));
        cars.add(new Car("Mercedes", "ML", 2022));
        cars.add(new Car("Nissan", "GTR", 2011));
        return cars;
    }

    public static List<Car> getCars(int num){
        List<Car> outputList = null;
        if (num > -1 && num < 6) {
            outputList = carsList().stream().limit(num).collect(Collectors.toList());
        }
        if (num > 5) {
            outputList = new ArrayList<>(carsList());
        }
        return outputList;
    }
}