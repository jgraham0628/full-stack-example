package gal.imperial.navy.session;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import gal.imperial.navy.entity.Facility;

/**
 * Session Bean implementation class FacilityBean
 */
@Stateless
@LocalBean
public class FacilityBean {

	/**
	 * Using injection, a part of the EE framework, we are able to tie the Entity Manager class, which we use for accessing the 
	 * database with EJB-QL, to the persistence unit we set up in the persistence.xml file earlier.
	 */
	@PersistenceContext(unitName = "empire")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public FacilityBean() {}
    
    @SuppressWarnings("unchecked")
	public Set<Facility> getAllFacilities() {
    	Set<Facility> results = new HashSet<>();
    	
    	//Remember, when we see the EJB-QL, we need to query the OBJECT, not the database table. It will provide a more direct 
    	//  method to retrieving the data from the database.
    	results.addAll(em.createQuery("FROM Facility f ORDER BY f.id ASC").getResultList());
    	
    	return results;
    }

}
