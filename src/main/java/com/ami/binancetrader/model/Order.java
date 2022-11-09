package com.ami.binancetrader.model;

import java.util.Date;
import java.util.Objects;

public class Order {
    private String symbol;
    private int leverage;
    private long amount;
    private float entryPrice;
    private float markPrice;

    public Order() {
    }

    public Order(String symbol, int leverage, long amount, float entryPrice, float markPrice) {
        this.symbol = symbol;
        this.leverage = leverage;
        this.amount = amount;
        this.entryPrice = entryPrice;
        this.markPrice = markPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public float getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(float entryPrice) {
        this.entryPrice = entryPrice;
    }

    public float getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(float markPrice) {
        this.markPrice = markPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return leverage == order.leverage && amount == order.amount && Float.compare(order.entryPrice, entryPrice) == 0
                && Float.compare(order.markPrice, markPrice) == 0 && symbol.equals(order.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, leverage, amount, entryPrice, markPrice);
    }

    @Override
    public String toString() {
        return "Order{" + "symbol='" + symbol + '\'' + ", leverage=" + leverage + ", amount=" + amount + ", entryPrice="
                + entryPrice + ", markPrice=" + markPrice + '}';
    }
}
