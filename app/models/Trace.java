package models;

import java.util.List;

import com.google.code.morphia.annotations.Embedded;

public class Trace {

	@Embedded
	List<SimulationEvent> eventList;
	
}
