/**
 * 
 */
package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import play.Logger;
import play.data.validation.Constraints.Required;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

import controllers.MorphiaObject;
/**
 * @author gouaich
 *
 */
public class Patient {

	@Id
	public ObjectId id;
	
	@Required
	public String givenName;
	
	@play.data.format.Formats.DateTime(pattern = "yyyy-MM-dd")
	public Date strokeDate;
	
	@Reference(lazy=true)
	List<Trace> myTraces;

	
	public static List<Patient> all() {
		if (MorphiaObject.datastore != null) {
			return MorphiaObject.datastore.find(Patient.class).asList();
		} else {
			return new ArrayList<Patient>();
		}
	}

	public static void create(Patient p) {
		MorphiaObject.datastore.save(p);
	}
	
	public static void delete(String idToDelete) {
		Patient toDelete = MorphiaObject.datastore.find(Patient.class).field("_id").equal(new ObjectId(idToDelete)).get();
		if (toDelete != null) {
			Logger.info("toDelete: " + toDelete);
			MorphiaObject.datastore.delete(toDelete);
		} else {
			Logger.debug("ID No Found: " + idToDelete);
		}
	}

	
	
}

