package com.nevermind.bu.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nevermind.bu.entity.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class HtmlParser {
    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Data> parseRawDataToData(String rawData) throws IOException {
        String preparedString = prepareStringForParsing(rawData);

        Data[] array = mapper.readValue(preparedString, Data[].class);
        List<Data> dataList = new ArrayList<>();
        Collections.addAll(dataList, array);
        return dataList;
    }

    private static String prepareStringForParsing(String rawData) {
        Document document = Jsoup.parse(rawData);
        List<Element> resultingElements = document.select("body").stream()
                .filter(item -> item.html().contains("data"))
                .collect(Collectors.toList());

        int start = resultingElements.get(0).html().indexOf("\"data\":");
        int end = resultingElements.get(0).html().lastIndexOf("}");
        String arrayOfData = resultingElements.get(0).html().substring(start, end + 1);
        String subString = arrayOfData.replaceFirst("\"data\":", "").trim();
        return subString.substring(0, subString.lastIndexOf("}"));
    }

}
