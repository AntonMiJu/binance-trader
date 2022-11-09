package com.ami.binancetrader.model;

import java.util.Objects;

public class Order {
    private String symbol;
    private String direction;
    private int leverage;
    private long amount;
    private float entryPrice;
    private float marketPrice;

    public Order() {
    }

    public Order(String symbol, String direction, int leverage, long amount, float entryPrice, float marketPrice) {
        this.symbol = symbol;
        this.direction = direction;
        this.leverage = leverage;
        this.amount = amount;
        this.entryPrice = entryPrice;
        this.marketPrice = marketPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(float marketPrice) {
        this.marketPrice = marketPrice;
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
                && Float.compare(order.marketPrice, marketPrice) == 0 && symbol.equals(order.symbol)
                && direction.equals(order.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, direction, leverage, amount, entryPrice, marketPrice);
    }
}
