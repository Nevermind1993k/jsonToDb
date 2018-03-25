package com.nevermind.bu.controller;

import com.nevermind.bu.client.DataClient;
import com.nevermind.bu.entity.Data;
import com.nevermind.bu.exception.GenericEngineException;
import com.nevermind.bu.service.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {

    private DataServiceImpl dataService;
    private DataClient dataClient;

    @Autowired
    public DataController(DataServiceImpl dataService, DataClient dataClient) {
        this.dataService = dataService;
        this.dataClient = dataClient;
    }

    @GetMapping("/list")
    public Iterable<Data> list() {
        return dataService.getAll();
    }

    @PostMapping("/thirdPartyData")
    public ResponseEntity loadDataFromThirdPartyServer() throws GenericEngineException {
        if (dataClient.fetchDataFromThirdPartyServer()) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
