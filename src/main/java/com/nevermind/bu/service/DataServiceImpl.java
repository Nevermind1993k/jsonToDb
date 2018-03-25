package com.nevermind.bu.service;

import com.nevermind.bu.dao.DataDao;
import com.nevermind.bu.entity.Data;
import com.nevermind.bu.exception.GenericEngineException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataDao dataDao;

    @Override
    public List<Data> getAll() {
        return dataDao.findAll();
    }

    @Override
    public Data save(Data data) throws GenericEngineException {
        return dataDao.save(data);
    }

    @Override
    public List<Data> save(List<Data> dataList) throws GenericEngineException {
        ArrayList<Data> result = new ArrayList<>();
        dataList.forEach(data -> {
            Data save = dataDao.save(data);
            result.add(save);
        });
        if (result != null && result.size() == dataList.size()) {
            return result;
        } else {
            throw new GenericEngineException("List of data was not saved");
        }
    }


}
