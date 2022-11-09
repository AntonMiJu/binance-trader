package com.ami.binancetrader.step;

import com.ami.binancetrader.model.Order;
import java.sql.Date;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PositionsStep implements Step {
    private Document document;

    public PositionsStep(Document document) {
        this.document = document;
    }

    @Override
    public void parse() {
        Elements positions = document.select("div.position-wrap")
                .select("tbody.bn-table-tbody")
                .select("tr.bn-table-row");

        if (positions.isEmpty()) {
            return;
        }

        for (Element position : positions) {
            parsePosition(position);
        }
    }

    private void parsePosition(Element position) {
        String symbol = position.attr("data-row-key");
        String direction = position.select("div.direction").text();
        int leverage = Integer.parseInt(position.select("div.leverage div").text().replace("x", ""));
        long size = Long.parseLong(position.getElementsByIndexEquals(1).text());
        float entryPrice = Float.parseFloat(position.getElementsByIndexEquals(2).text());
        float marketPrice = Float.parseFloat(position.getElementsByIndexEquals(3).text());

        Order order = new Order(symbol, direction, leverage, size, entryPrice, marketPrice);
    }
}
