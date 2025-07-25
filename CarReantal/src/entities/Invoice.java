package entities;

public class Invoice {
    private Double basicPayment;
    private Double tax;

    public Invoice(){
    }

    public Invoice(Double basicPayment, Double tax){
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public void setBasicPayment(Double basicPayment){
        this.basicPayment = basicPayment;
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public void SetTax(Double tax){
        this.tax = tax;
    }

    public Double getTax() {
        return tax;
    }

    public Double getTotalPayment(){
        return getBasicPayment() +getTax();
    }
}
