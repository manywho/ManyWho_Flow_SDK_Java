package com.manywho.sdk.services.describe;

import com.fasterxml.jackson.databind.node.TextNode;
import com.google.common.collect.Lists;
import com.manywho.sdk.api.ContentType;
import com.manywho.sdk.api.run.elements.config.ListenerServiceRequest;
import com.manywho.sdk.api.run.elements.config.SocialServiceRequest;
import com.manywho.sdk.api.run.elements.type.FileDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataRequest;
import com.manywho.sdk.api.run.elements.type.ObjectDataResponse;
import com.manywho.sdk.api.security.AuthenticatedWhoResult;
import com.manywho.sdk.api.security.AuthenticationCredentials;
import com.manywho.sdk.api.social.MentionedWho;
import com.manywho.sdk.api.social.Message;
import com.manywho.sdk.api.social.MessageList;
import com.manywho.sdk.api.social.Who;
import com.manywho.sdk.services.actions.ActionCommand;
import com.manywho.sdk.services.actions.ActionRepository;
import com.manywho.sdk.services.actions.ActionResponse;
import com.manywho.sdk.services.configuration.Configuration;
import com.manywho.sdk.services.configuration.ConfigurationRepository;
import com.manywho.sdk.services.controllers.AbstractDataController;
import com.manywho.sdk.services.controllers.AbstractFileController;
import com.manywho.sdk.services.controllers.AbstractIdentityController;
import com.manywho.sdk.services.controllers.AbstractListenerController;
import com.manywho.sdk.services.controllers.AbstractSocialController;
import com.manywho.sdk.services.types.Type;
import com.manywho.sdk.services.types.TypeRepository;
import com.manywho.sdk.services.validation.social.CreateStream;
import com.manywho.sdk.services.validation.social.DeleteMessage;
import com.manywho.sdk.services.validation.social.FollowStream;
import com.manywho.sdk.services.validation.social.GetCurrentUser;
import com.manywho.sdk.services.validation.social.GetStreamFollowers;
import com.manywho.sdk.services.validation.social.GetStreamMessages;
import com.manywho.sdk.services.validation.social.GetUser;
import com.manywho.sdk.services.validation.social.LikeMessage;
import com.manywho.sdk.services.validation.social.PostNewMessage;
import com.manywho.sdk.services.validation.social.SearchUsersByName;
import com.manywho.sdk.services.validation.social.ShareMessage;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.junit.Test;
import org.reflections.Reflections;

import javax.ws.rs.PathParam;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DescribeServiceTest extends BaseTest {
    @Test
    public void testAnyActionsDefinedWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyActionsDefined());
    }

    @Test
    public void testAnyActionsDefinedWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyActionsDefined());
    }

    @Test
    public void testAnyConfigurationValuesExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyConfigurationValuesExist());
    }

    @Test
    public void testAnyConfigurationValuesExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyConfigurationValuesExist());
    }

    @Test
    public void testAnyDataControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyDataControllersExist());
    }

    @Test
    public void testAnyDataControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyDataControllersExist());
    }

    @Test
    public void testAnyFileControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyFileControllersExist());
    }

    @Test
    public void testAnyFileControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyFileControllersExist());
    }

    @Test
    public void testAnyIdentityControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyIdentityControllersExist());
    }

    @Test
    public void testAnyIdentityControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyIdentityControllersExist());
    }

    @Test
    public void testAnyListenerControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyListenerControllersExist());
    }

    @Test
    public void testAnyListenerControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyListenerControllersExist());
    }

    @Test
    public void testAnySocialControllersExistWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anySocialControllersExist());
    }

    @Test
    public void testAnySocialControllersExistWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anySocialControllersExist());
    }

    @Test
    public void testAnyTypedDefinedWithTestClass() {
        DescribeService describeService = createDescribeService();

        assertTrue(describeService.anyTypesDefined());
    }

    @Test
    public void testAnyTypesDefinedWithoutTestClass() {
        reflectionsConfiguration.setUrls(Lists.newArrayList());

        DescribeService describeService = createDescribeService();

        assertFalse(describeService.anyTypesDefined());
    }

    private DescribeService createDescribeService() {
        Reflections reflections = createReflections();

        return new DescribeService(new ActionRepository(reflections), new ConfigurationRepository(reflections), new DescribeRepository(reflections), new TypeRepository(reflections));
    }

    private class TestAction implements ActionCommand<TestAction, TestAction, TestAction> {

        @Override
        public ActionResponse<TestAction> execute(TestAction input) {
            return null;
        }
    }

    private class TestConfigurationValues {
        @Configuration.Value(name = "Value One", contentType = ContentType.String)
        private String valueOne;

        @Configuration.Value(name = "Value Two", contentType = ContentType.String, required = false)
        private String valueTwo;
    }

    private class TestDataController extends AbstractDataController {

        @Override
        public ObjectDataResponse delete(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse load(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse save(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }
    }

    private class TestFileController extends AbstractFileController {

        @Override
        public ObjectDataResponse loadFiles(FileDataRequest fileDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse uploadFile(@FormDataParam("FileDataRequest") FileDataRequest fileDataRequest,
                                             @FormDataParam("file") FormDataContentDisposition fileInformation,
                                             @FormDataParam("file") InputStream file) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse deleteFile(FileDataRequest fileDataRequest) throws Exception {
            return null;
        }
    }

    private class TestIdentityController extends AbstractIdentityController {

        @Override
        public AuthenticatedWhoResult authentication(AuthenticationCredentials authenticationCredentials) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse authorization(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse groupAttributes(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse groups(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse userAttributes(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }

        @Override
        public ObjectDataResponse users(ObjectDataRequest objectDataRequest) throws Exception {
            return null;
        }
    }

    private class TestListenerController extends AbstractListenerController {

        @Override
        public void createListener(ListenerServiceRequest listenerServiceRequest) throws Exception {

        }
    }

    private class TestSocialController extends AbstractSocialController {

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

    @Type.Element(name = "Test Element")
    private class TestType {

    }
}
