package Entities;

public class Mortgage {

    private double initialDeposit;
    private double interestRate;
    public double periodicPayment; //how much are you going to pay monthly
    private double timePermanency; //how much time of payment is it left
    private String name;

    public Mortgage(double initialDeposit, double interestRate, double periodicPayment, double timePermanency, String name){
        this.initialDeposit = initialDeposit;
        this.interestRate = interestRate;
        this.periodicPayment = periodicPayment;
        this.timePermanency = timePermanency;
        this.name = name;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getPeriodicPayment() {
        return periodicPayment;
    }

    public void setPeriodicPayment(double periodicPayment) {
        this.periodicPayment = periodicPayment;
    }

    public double getTimePermanency() {
        return timePermanency;
    }

    public void setTimePermanency(double timePermanency) {
        this.timePermanency = timePermanency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}