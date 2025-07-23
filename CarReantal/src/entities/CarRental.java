package entities;

import java.time.LocalDateTime;

public class CarRental {

    private LocalDateTime start;
    private LocalDateTime finish;
    private Car car;
    private Invoice invoice;

    public CarRental(){
    }

    public CarRental(LocalDateTime start, LocalDateTime finish,Car car){
        this.finish = finish;
        this.start = start;
        this.car = car;
    }

    public void setStart(LocalDateTime start){
        this.start = start;
    }

    public LocalDateTime getStart(){
        return start;
    }

    public void setFinish(LocalDateTime finish){
        this.finish = finish;
    }

    public LocalDateTime getFinish(){
        return finish;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
