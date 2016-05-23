package com.manywho.sdk.services.unit.entities;

import com.fasterxml.jackson.databind.node.TextNode;
import com.manywho.sdk.api.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.api.social.MentionedWho;
import com.manywho.sdk.api.social.Message;
import com.manywho.sdk.api.social.MessageList;
import com.manywho.sdk.api.social.Who;
import com.manywho.sdk.services.controllers.AbstractSocialController;
import com.manywho.sdk.services.validation.social.*;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.PathParam;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class TestSocialController extends AbstractSocialController {

    @Override
    public TextNode createStream(@CreateStream SocialServiceRequest serviceRequest) throws Exception {
        return null;
    }

    @Override
    public TextNode deleteMessage(@DeleteMessage SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId, @PathParam("messageId") UUID messageId) throws Exception {
        return null;
    }

    @Override
    public TextNode followStream(@FollowStream SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId, @PathParam("follow") boolean follow) throws Exception {
        return null;
    }

    @Override
    public Who getCurrentUser(@GetCurrentUser SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId) throws Exception {
        return null;
    }

    @Override
    public List<Who> getStreamFollowers(@GetStreamFollowers SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId) throws Exception {
        return null;
    }

    @Override
    public MessageList getStreamMessages(@GetStreamMessages SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId) throws Exception {
        return null;
    }

    @Override
    public Who getUser(@GetUser SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId, @PathParam("userId") String userId) throws Exception {
        return null;
    }

    @Override
    public TextNode likeMessage(@LikeMessage SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId, @PathParam("messageId") UUID messageId, @PathParam("like") boolean like) throws Exception {
        return null;
    }

    @Override
    public Message postNewMessage(@PostNewMessage @FormDataParam("serviceRequest") SocialServiceRequest serviceRequest, @FormDataParam("file") InputStream file, @FormDataParam("file") FormDataContentDisposition fileDetails, @PathParam("id") UUID streamId) throws Exception {
        return null;
    }

    @Override
    public List<MentionedWho> searchUsersByName(@SearchUsersByName SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId, @PathParam("name") String name) throws Exception {
        return null;
    }

    @Override
    public Message shareMessage(@ShareMessage @FormDataParam("serviceRequest") SocialServiceRequest serviceRequest, @PathParam("id") UUID streamId) throws Exception {
        return null;
    }
}
