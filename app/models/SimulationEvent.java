package models;

import java.util.List;

import com.google.code.morphia.annotations.Embedded;

public class SimulationEvent {

	public String type;
	@Embedded
	public List<String> arguments;
}
