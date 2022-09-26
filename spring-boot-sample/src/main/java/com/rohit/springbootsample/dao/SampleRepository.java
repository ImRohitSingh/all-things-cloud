package com.rohit.springbootsample.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rohit.springbootsample.models.SampleData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SampleRepository {

	private List<SampleData> sampleStorage = new LinkedList<>();

	public void save(SampleData sampleData) {
		sampleStorage.add(sampleData);
		log.info("{} saved", sampleData);
	}

	public List<SampleData> findAll() {
		return sampleStorage;
	}

	public SampleData findById(String id) {
		return sampleStorage.stream().filter(r -> id.equals(r.getId())).findAny().orElse(null);
	}

	public Boolean deleteById(String id) {
		return sampleStorage.removeIf(data -> id.equals(data.getId()));
	}

}
