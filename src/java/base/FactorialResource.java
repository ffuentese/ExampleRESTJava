package base;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Stateless

@Path("/factorial")
public class FactorialResource {

    @GET
    public String factorial(@QueryParam("base") long base){
    return Long.toString($factorial(base));
    }
    
     long $factorial(long base) {
        if (base >= 1) {
            return $factorial(base - 1) * base;
        }
        return 1;
    }

}
