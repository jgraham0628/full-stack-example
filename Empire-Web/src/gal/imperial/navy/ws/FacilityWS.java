package gal.imperial.navy.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import gal.imperial.navy.annotation.FeatureToggle;
import gal.imperial.navy.entity.Facility;
import gal.imperial.navy.session.FacilityBean;

@Stateless
@Path("/facilities")
public class FacilityWS {

	@EJB
	private FacilityBean facilityBean;
	
	private JsonBuilderFactory factory = Json.createBuilderFactory(null);
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	@FeatureToggle(lockedDown = true)
	public Response listAll(@QueryParam("start") final Integer startPosition,
			@QueryParam("max") final Integer maxResult) {
		final Set<Facility> facilities = new HashSet<>();
		
		facilities.addAll(facilityBean.getAllFacilities());
		
		JsonArrayBuilder array = factory.createArrayBuilder();
		facilities.stream().forEachOrdered(facility -> {
			array.add(facility.toJSON());
		});
		JsonArray results = array.build();
		
		return Response.ok(results, MediaType.APPLICATION_JSON).build();
	}

}
