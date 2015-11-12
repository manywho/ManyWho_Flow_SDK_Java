package com.manywho.sdk.services.controllers;

import com.manywho.sdk.entities.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.entities.social.MentionedWho;
import com.manywho.sdk.entities.social.Message;
import com.manywho.sdk.entities.social.MessageList;
import com.manywho.sdk.entities.social.Who;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/social")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class AbstractSocialController {

    @Path("/stream")
    @POST
    public abstract String createStream(SocialServiceRequest serviceRequest) throws Exception;

    @Path("/stream/{id}")
    @POST
    public abstract MessageList getStreamMessages(SocialServiceRequest serviceRequest, @PathParam("id") String id)
            throws Exception;

    @Path("/stream/{id}/user/me")
    @POST
    public abstract Who getCurrentUser(SocialServiceRequest serviceRequest, @PathParam("id") String id)
            throws Exception;

    @Path("/stream/{id}/user/name/{name}")
    @POST
    public abstract List<MentionedWho> searchUsersByName(SocialServiceRequest serviceRequest,
                                                         @PathParam("id") String id,
                                                         @PathParam("name") String name)
            throws Exception;

    @Path("/stream/{id}/user/{userId}")
    @POST
    public abstract Who getUser(SocialServiceRequest serviceRequest, @PathParam("id") String id,
                                @PathParam("userId") String userId)
            throws Exception;

    @Path("/stream/{id}/follower")
    @POST
    public abstract List<Who> getStreamFollowers(SocialServiceRequest serviceRequest, @PathParam("id") String id)
            throws Exception;

    @Path("/stream/{id}/share")
    @POST
    public abstract Message shareMessage(@PathParam("id") String id) throws Exception;

    @Path("/stream/{id}/message")
    @POST
    public abstract Message postNewMessage(@PathParam("id") String id) throws Exception;

    @Path("/stream/{id}/message/{messageId}/like/{like}")
    @POST
    public abstract String likeMessage(SocialServiceRequest serviceRequest, @PathParam("id") String id,
                                       @PathParam("messageId") String messageId,
                                       @PathParam("like") String like)
            throws Exception;

    @Path("/stream/{id}/message/{messageId}")
    @POST
    public abstract String deleteMessage(SocialServiceRequest serviceRequest, @PathParam("id") String id,
                                       @PathParam("messageId") String messageId)
            throws Exception;

    @Path("/stream/{id}/follow/{follow}")
    @POST
    public abstract String followStream(SocialServiceRequest serviceRequest, @PathParam("id") String id,
                                      @PathParam("follow") String follow)
            throws Exception;
}
