package com.ami.binancetrader.step;

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

        for (Element position : positions) {
            String symbol = position.attr("data-row-key");

        }
    }
}
