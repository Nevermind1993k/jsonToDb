package com.nevermind.bu.service;

import com.nevermind.bu.entity.Data;
import com.nevermind.bu.exception.GenericEngineException;

import java.util.List;

public interface DataService {
    Data save(Data data) throws GenericEngineException;

    List<Data> save(List<Data> dataList) throws GenericEngineException;

    List<Data> getAll();

}
