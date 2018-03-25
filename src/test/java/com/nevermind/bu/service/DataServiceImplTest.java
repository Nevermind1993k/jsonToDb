package com.nevermind.bu.service;

import com.nevermind.bu.entity.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DataServiceImplTest {

    @Mock
    @Autowired
    DataService dataService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAll() throws Exception {
        List<Data> all = new ArrayList<>();
        all.add(new Data());
        all.add(new Data());
        when(dataService.getAll()).thenReturn(all);

        List<Data> result = dataService.getAll();
        verify(dataService).getAll();
    }

    @Test
    public void save() throws Exception {
        Data data = new Data();
        data.setTitle("Some Title");
        dataService.save(data);
        verify(dataService).save(data);
    }

    @Test
    public void testServiceCalledOnlyOnce() {
        List<Data> all = new ArrayList<>();

        when(dataService.getAll()).thenReturn(all);

        dataService.getAll();

        verify(dataService, times(1)).getAll();
        verify(dataService, atMost(1)).getAll();
        verify(dataService, atLeast(1)).getAll();
    }


}
