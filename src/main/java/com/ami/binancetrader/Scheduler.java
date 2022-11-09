package com.ami.binancetrader;

import com.ami.binancetrader.model.Order;
import com.binance.connector.client.impl.spot.Margin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private ObjectMapper objectMapper;

    @Autowired
    public Scheduler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Scheduled(fixedDelay = 5000)
    public void parseCurrentPositions() throws IOException {

        String json = Jsoup.connect("https://www.binance.com/bapi/futures/v1/public/future/leaderboard/getOtherPosition")
                .requestBody("{\"encryptedUid\":\"FB23E1A8B7E2944FAAEC6219BBDF8243\",\"tradeType\":\"PERPETUAL\"}")
                .ignoreContentType(true)
                .header("Content-Type", "application/json")
                .method(Connection.Method.POST)
                .execute().body();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode node = objectMapper.readTree(json).get("data").get("otherPositionRetList");
        List<Order> orders = objectMapper.readValue(node.toString(), new TypeReference<>() {});
        System.out.println(orders);
    }
}
