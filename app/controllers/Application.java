package controllers;

import models.Group;
import models.Patient;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import controllers.*;

public class Application extends Controller {
	static Form<Group> groupForm = new Form<Group>(Group.class);
	static Form<Patient> patientForm = new Form<Patient>(Patient.class);

	public static Result index() throws Exception 
	{
		// redirect to the "group Result
		return redirect(controllers.routes.Application.group());
	}

	public static Result group() {
		return ok(views.html.index.render(Group.all(), groupForm));
	}

	public static Result newGroup() {
		Form<Group> filledForm = groupForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Group.all(), filledForm));
		} else {
			Group.create(filledForm.get());
			return redirect(controllers.routes.Application.group());  
		}
	}
	
	public static Result deleteGroup(String id) {
		Group.delete(id);
		return redirect(controllers.routes.Application.group());
	}

	public static Result patient() {
		return ok(views.html.patient.render(Patient.all(), patientForm));
	}

	public static Result newPatient() {
		Form<Patient> filledForm = patientForm.bindFromRequest();
		if(filledForm.hasErrors()) {
			return badRequest(views.html.patient.render(Patient.all(), filledForm));
		} else {
			Patient.create(filledForm.get());
			return redirect(controllers.routes.Application.patient());  
		}
	}
	
	public static Result deletePatient(String id) {
		Patient.delete(id);
		return redirect(controllers.routes.Application.patient());
	}
	
}