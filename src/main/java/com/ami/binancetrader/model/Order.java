package com.ami.binancetrader.model;

import java.util.Date;
import java.util.Objects;

public class Order {
    private String symbol;
    private String direction;
    private int leverage;
    private long size;
    private float entryPrice;
    private float marketPrice;

    public Order() {
    }

    public Order(String symbol, String direction, int leverage, long size, float entryPrice, float marketPrice) {
        this.symbol = symbol;
        this.direction = direction;
        this.leverage = leverage;
        this.size = size;
        this.entryPrice = entryPrice;
        this.marketPrice = marketPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getLeverage() {
        return leverage;
    }

    public void setLeverage(int leverage) {
        this.leverage = leverage;
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
        return leverage == order.leverage && size == order.size && Float.compare(order.entryPrice, entryPrice) == 0
                && Float.compare(order.marketPrice, marketPrice) == 0 && symbol.equals(order.symbol)
                && direction.equals(order.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, direction, leverage, size, entryPrice, marketPrice);
    }
}
