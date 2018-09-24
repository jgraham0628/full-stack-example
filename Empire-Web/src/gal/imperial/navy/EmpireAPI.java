package gal.imperial.navy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import gal.imperial.navy.ws.FacilityWS;

@ApplicationPath("/api")
public class EmpireAPI extends Application {

	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(FacilityWS.class);
        return s;
    }
}
