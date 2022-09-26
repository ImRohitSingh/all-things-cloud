package com.rohit.springbootsample.models;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SampleData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private ZonedDateTime timestamp;
}
