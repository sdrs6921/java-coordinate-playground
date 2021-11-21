package rentcar.domain;

import rentcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {

    private static final String NEWLINE = System.getProperty("line.separator");
    private static final String DELIMITER = " : ";
    private static final String LITER = "리터";

    List<Car> cars;

    private RentCompany(final List<Car> cars) {
        this.cars = cars;
    }

    public static RentCompany create() {
        return new RentCompany(new ArrayList<>());
    }

    public void addCar(final Car car) {
        cars.add(car);
    }

    public String generateReport() {
        StringBuilder report = new StringBuilder();

        for (Car car : cars) {
            report.append(car.getName());
            report.append(DELIMITER);
            report.append((int) car.getChargeQuantity());
            report.append(LITER);
            report.append(NEWLINE);
        }

        return report.toString();
    }
}
