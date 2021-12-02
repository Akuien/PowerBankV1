package Entities;

import java.util.ArrayList;

public class CompanyStock {

    private String name; // Shorter name then the company name "AMZN".
    private String companyName; // example Amazon
    private double tradingPrice; //Price for buying one share
    private double ValuePercentChange; // If the stock has decreased or increased %
    private double companyMarketValue; // tradingPrice * TotalCapitalShares
    private double TotalCapitalShares; // total amount of shares that are for sale.
    private int totalStockHolder; // amount of people owns the stock

    private ArrayList<CompanyStock> stockList = new ArrayList();


    //constructor


    public CompanyStock(String name, String companyName, double tradingPrice, double valuePercentChange, double companyMarketValue, double totalCapitalShares, int totalStockHolder) {
        this.name = name;
        this.companyName = companyName;
        this.tradingPrice = tradingPrice;
        this.ValuePercentChange = valuePercentChange;
        this.companyMarketValue = companyMarketValue;
        this.TotalCapitalShares = totalCapitalShares;
        this.totalStockHolder = totalStockHolder;
    }

    public double CalCompanyMarketValue(double tradingPrice, int totalStockHolder){
        companyMarketValue = tradingPrice * totalStockHolder;
        return companyMarketValue;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return ValuePercentChange;
    }

    public void setValuePercentChange(double valuePercentChange) {
        ValuePercentChange = valuePercentChange;
    }

    public double getCompanyMarketValue() {
        return companyMarketValue;
    }

    public void setCompanyMarketValue(double companyMarketValue) {
        this.companyMarketValue = companyMarketValue;
    }

    public double getTotalCapitalShares() {
        return TotalCapitalShares;
    }

    public void setTotalCapitalShares(double totalCapitalShares) {
        TotalCapitalShares = totalCapitalShares;
    }

    public int getTotalStockHolder() {
        return totalStockHolder;
    }

    public void setTotalStockHolder(int totalStockHolder) {
        this.totalStockHolder = totalStockHolder;
    }

    public ArrayList<CompanyStock> getStockList() {
        return stockList;
    }

    public void setStockList(ArrayList<CompanyStock> stockList) {
        this.stockList = stockList;
    }
}

