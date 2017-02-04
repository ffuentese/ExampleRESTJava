/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

/**
 *
 * @author Francisco
 */
@Stateless
@Path("/country")
public class CountryResource {

    CountryDAO cdao = new CountryDAO();

    List<Country> countries = cdao.readAll();
    GenericEntity<List<Country>> entity = new GenericEntity<List<Country>>(countries) {};

    @GET
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response read(@QueryParam("id") String id) {
        try {
                Country c = cdao.read(id);

                if (c != null) {
                    return Response.status(200).entity(c).build();
                } else {
                    return Response.status(400).entity(String.format("Error: No country with such ID in server.")).build();
                }
        } catch (NumberFormatException nfe) {
            if (id.isEmpty()) {
                return Response.status(200).entity(entity).build();
            }
            return Response.status(400).entity(String.format("Error: No valid ID provided.")).build();
        }
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public Response save(Country c) {
        if (cdao.create(c)) {
            return Response.status(200).entity(c).build();
        };
        return Response.status(400).entity(c).build();

    }
}
