package service;

import entities.CarRental;
import entities.Invoice;
import interfaces.TaxService;

import java.io.DataOutput;
import java.time.Duration;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService){
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes/60;
        double basicPayment;
        if(hours <=12.0){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else{
            basicPayment = pricePerDay * Math.ceil(hours/24.0);
        }
        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment,tax));
    }
}
