package com.rohit.springbootsample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.springbootsample.models.SampleData;
import com.rohit.springbootsample.service.SampleService;

@RestController
public class SampleDataController {

	private final SampleService sampleService;

	@Autowired
	public SampleDataController(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	@PostMapping(path = "/save")
	@ResponseStatus(code = HttpStatus.CREATED, reason = "sample data saved")
	public void save(@RequestBody SampleData sampleData) {
		sampleService.save(sampleData);
	}

	@GetMapping(path = "/getAll")
	public ResponseEntity<List<SampleData>> getAll() {
		return new ResponseEntity<>(sampleService.getAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/getById/{id}")
	public ResponseEntity<SampleData> getById(@PathVariable(name = "id") String id) {
		return new ResponseEntity<>(sampleService.getById(id), HttpStatus.OK);
	}
}
