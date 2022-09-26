package com.rohit.springbootsample.service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.springbootsample.dao.SampleRepository;
import com.rohit.springbootsample.models.SampleData;

@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public void save(SampleData sampleData) {
        sampleRepository.save(new SampleData(UUID.randomUUID().toString(), sampleData.getName(), ZonedDateTime.now()));
    }

    public List<SampleData> getAll() {
        return sampleRepository.findAll();
    }

    public SampleData getById(String id) {
        return sampleRepository.findById(id);
    }
}
