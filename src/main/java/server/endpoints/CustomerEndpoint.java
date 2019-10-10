package server.endpoints;

import com.google.gson.Gson;
import server.controllers.CustomerController;
import server.models.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/customers")
public class CustomerEndpoint {

    @GET
    @Path("{id}")
    public Response getCustomer(@PathParam("id") int id){
        //TODO complete this method
        return null;
    }

    @GET
    public Response getCustomers(){
        // Get a list of users
        ArrayList<Customer> users = CustomerController.getCustomers();
        String out = new Gson().toJson(users);

        // Return the users with the status code 200
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity(out).build();
    }

    @POST
    public Response createCustomer(String customer) {
        //TODO complete this method
        return null;
    }

    @PUT
    public Response updateCustomer(String customer) {
        //TODO complete this method
        return null;
    }
}
