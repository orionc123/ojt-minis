package org.example.myResources;

import org.example.model.Message;
import org.example.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("message")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessages(){
        List<Message> messages = messageService.getMessages();

        GenericEntity<List<Message>> entity = new GenericEntity<List<Message>>(messages){};
        return Response.status(200).entity(entity).build();
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMessage(@PathParam("id") long id){
        final Message message = messageService.getMessage(id);
        if (message == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        GenericEntity<Message> entity = new GenericEntity<Message>(message){};
        return Response.status(200).entity(entity).build();
    }
}
