package Entities;

import java.util.ArrayList;
import java.util.Random;

public class CompanyStock {

    private String companyName; // example Amazon
    private double tradingPrice; //Price for buying one share
    private double valuePercentChange; // If the stock has decreased or increased %
    private double companyMarketValue; // tradingPrice * TotalCapitalShares
    private double totalCapitalShares; // total amount of shares that are for sale.
    private int totalStockHolder; // amount of people owns the stock

    /*private ArrayList<CompanyStock> stockList = new ArrayList();*/


    //constructor


    public CompanyStock( String companyName, double tradingPrice, double valuePercentChange, double companyMarketValue, double totalCapitalShares, int totalStockHolder) {
        this.companyName = companyName;
        this.tradingPrice = tradingPrice;
        this.valuePercentChange = valuePercentChange;
        this.companyMarketValue = companyMarketValue;
        this.totalCapitalShares = totalCapitalShares;
        this.totalStockHolder = totalStockHolder;
    }

    //Calculates the value of the company at is whole.
    public double CalCompanyMarketValue(double tradingPrice, int totalCapitalShares){
        companyMarketValue = tradingPrice * totalCapitalShares;
        return companyMarketValue;
    }

    @Override
    public String toString() {
        return "CompanyStock{" +
                "companyName='" + companyName + '\'' +
                ", tradingPrice=" + tradingPrice +
                ", ValuePercentChange=" + valuePercentChange +
                ", companyMarketValue=" + companyMarketValue +
                ", TotalCapitalShares=" + totalCapitalShares +
                ", totalStockHolder=" + totalStockHolder +
                '}';
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getTradingPrice() {
        return tradingPrice;
    }

    public void setTradingPrice(double tradingPrice) {
        this.tradingPrice = tradingPrice;
    }

    public double getValuePercentChange() {
        return valuePercentChange;
    }

    public void setValuePercentChange(double valuePercentChange) {
        valuePercentChange = valuePercentChange;
    }

    public double getCompanyMarketValue() {
        return companyMarketValue;
    }

    public void setCompanyMarketValue(double companyMarketValue) {
        this.companyMarketValue = companyMarketValue;
    }

    public double getTotalCapitalShares() {
        return totalCapitalShares;
    }

    public void setTotalCapitalShares(double totalCapitalShares) {
        totalCapitalShares = totalCapitalShares;
    }

    public int getTotalStockHolder() {
        return totalStockHolder;
    }

    public void setTotalStockHolder(int totalStockHolder) {
        this.totalStockHolder = totalStockHolder;
    }

    /*public ArrayList<CompanyStock> getStockList() {
        return stockList;
    }

    public void setStockList(ArrayList<CompanyStock> stockList) {
        this.stockList = stockList;
    }*/
}

