package gal.imperial.navy.util;

/**
 * Enumeration used to represent the current state of a facility.
 * 
 * We use a custom private constructor to allow for a more human readable version of the enumeration to be 
 * displayed with called to a string format.
 * 
 * @author Jonathan
 *
 */
public enum FacilityStatus {
	IN_CONSTRUCTION("IN CONSTRUCTION"),
	OPERATION_FULL("FULL OPERATION STATE"),
	OPERATION_SKEL("MINIMAL OPERATION STATE"),
	DISABLED("DISABLED"),
	DESTROYED("DESTROYED");
	
	/**
	 * The custom, human readable string value of the enumeration
	 */
	private String desc;
	
	/**
	 * Custom private constructor to allow for the human readable version of the enumeration.
	 * @param desc the human readable version of the enumeration
	 */
	private FacilityStatus(String desc) {
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return this.desc;
	}
}
