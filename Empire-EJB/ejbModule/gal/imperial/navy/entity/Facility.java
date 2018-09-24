package gal.imperial.navy.entity;

import java.io.Serializable;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import gal.imperial.navy.util.FacilityStatus;
import lombok.Data;

/**	
 * Class for representing an imperial facility.
 * 
 * Using Lombok to now have to worry about the default getter and setters of the class.
 * 
 * Adding the Entity annotation allows for the persistence to be able to tie this class to a database table upon deployment with 
 * the same name of the class.
 * 
 * @author Jonathan
 *
 */
@Entity
@Data	
public class Facility implements Serializable{

	/**
	 * Serial Version ID value used for version control of the object
	 */
	private static final long serialVersionUID = 1921284517552082760L;
	
	/**
	 * Unique ID value from the DB.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	/**
	 * Human readable designation for location
	 */
	private String name;
	/**
	 * Spacial location designation
	 */
	private String location;
	/**
	 * The current state of the facility
	 */
	@Enumerated
	private FacilityStatus currentState;
	
	/**
	 * Convenience method for converting a instance of this object into a JSON object
	 * @return the JSON string of the object
	 */
	public JsonObject toJSON() {
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		return factory.createObjectBuilder().add("id", this.id)
			.add("name", this.name)
			.add("location", this.location)
			.add("status", this.currentState.toString())
		.build();
	}
}
