import entities.Car;
import entities.CarRental;
import service.BrazilTaxService;
import service.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter whit the infomation");
        System.out.print("Model of car: ");
        String carModel = sc.nextLine();
        System.out.print("Start(dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
        System.out.print("Finish(dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);

        CarRental cr =new CarRental(start,finish, new Car(carModel));

        System.out.print("Enter whith price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Enter whith price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("Invoice: ");
        System.out.println("Basic Payment: "+String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: "+ String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment: "+ String.format("%.2f", cr.getInvoice().getTotalPayment()));


        sc.close();
    }
}