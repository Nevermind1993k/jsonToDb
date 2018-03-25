package com.nevermind.bu.client;

import com.nevermind.bu.entity.Data;
import com.nevermind.bu.exception.GenericEngineException;
import com.nevermind.bu.service.DataServiceImpl;
import com.nevermind.bu.utility.HtmlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DataClient {

    @Value("${systemProperty.dataServer}")
    private String URL_SERVER_TO_GET_DATA_FROM;

    private DataServiceImpl dataService;

    @Autowired
    public DataClient(DataServiceImpl dataService) {
        this.dataService = dataService;
    }

    public boolean fetchDataFromThirdPartyServer() throws GenericEngineException {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String rawRequestResult = restTemplate.getForObject(URL_SERVER_TO_GET_DATA_FROM, String.class);

            List<Data> dataList = HtmlParser.parseRawDataToData(rawRequestResult);

            dataService.save(dataList);
            return true;
        } catch (Exception e) {
            throw new GenericEngineException("Could not fetch and store data from the third party server");
        }

    }
}
