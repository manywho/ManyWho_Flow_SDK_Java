package com.manywho.sdk.services.unit.identity;

import com.manywho.sdk.api.jackson.ObjectMapperFactory;
import com.manywho.sdk.api.security.AuthenticatedWho;
import com.manywho.sdk.services.identity.AuthorizationEncoder;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class AuthorizationEncoderTest {
    private static final String ENCODED = "ManyWhoTenantId%3Daa606806-642f-4d3b-8a0b-9c06e0a7a7c4%26ManyWhoUserId%3D52df1a90-3826-4508-b7c2-cde8aa5b72cf%26ManyWhoToken%3DTWFueVdob1RlbmFudElkPWFhNjA2ODA2LTY0MmYtNGQzYi04YTBiLTljMDZlMGE3YTdjNCZNYW55V2hvVXNlcklkPTUyZGYxYTkwLTM4MjYtNDUwOC1iN2MyLWNkZThhYTViNzJjZiZNYW55V2hvVG9rZW49RFVNTVkmRGlyZWN0b3J5SWQ9VU5BVVRIRU5USUNBVEVEJkRpcmVjdG9yeU5hbWU9VU5LTk9XTiZSb2xlSWQ9VU5BVVRIRU5USUNBVEVEJlJvbGVOYW1lPVVOS05PV04mUHJpbWFyeUdyb3VwSWQ9VU5BVVRIRU5USUNBVEVEJlByaW1hcnlHcm91cE5hbWU9VU5LTk9XTiZFbWFpbD1hZG1pbkBtYW55d2hvLmNvbSZJZGVudGl0eVByb3ZpZGVyPU5PTkUmVGVuYW50TmFtZT1VTktOT1dOJlRva2VuPU5PTkUmVXNlcm5hbWU9JlVzZXJJZD1QVUJMSUNfVVNFUiZGaXJzdE5hbWU9Jkxhc3ROYW1lPQ%253D%253D%26DirectoryId%3DUNAUTHENTICATED%26DirectoryName%3DUNKNOWN%26RoleId%3DUNAUTHENTICATED%26RoleName%3DUNKNOWN%26PrimaryGroupId%3DUNAUTHENTICATED%26PrimaryGroupName%3DUNKNOWN%26Email%3Dadmin%40manywho.com%26IdentityProvider%3DNONE%26TenantName%3DUNKNOWN%26Token%3DNONE%26Username%3D%26UserId%3DPUBLIC_USER%26FirstName%3D%26LastName%3D";

    private AuthorizationEncoder authorizationEncoder;

    public AuthorizationEncoderTest() {
        this.authorizationEncoder = new AuthorizationEncoder(ObjectMapperFactory.create());
    }

    @Test
    public void testDecode() {
        AuthenticatedWho result = authorizationEncoder.decode(ENCODED);

        assertEquals("UNAUTHENTICATED", result.getDirectoryId());
        assertEquals("UNKNOWN", result.getDirectoryName());
        assertEquals("admin@manywho.com", result.getEmail());
        assertEquals("", result.getFirstName());
        assertEquals("NONE", result.getIdentityProvider());
        assertEquals("", result.getLastName());
        assertEquals(UUID.fromString("aa606806-642f-4d3b-8a0b-9c06e0a7a7c4"), result.getManyWhoTenantId());
        assertEquals("TWFueVdob1RlbmFudElkPWFhNjA2ODA2LTY0MmYtNGQzYi04YTBiLTljMDZlMGE3YTdjNCZNYW55V2hvVXNlcklkPTUyZGYxYTkwLTM4MjYtNDUwOC1iN2MyLWNkZThhYTViNzJjZiZNYW55V2hvVG9rZW49RFVNTVkmRGlyZWN0b3J5SWQ9VU5BVVRIRU5USUNBVEVEJkRpcmVjdG9yeU5hbWU9VU5LTk9XTiZSb2xlSWQ9VU5BVVRIRU5USUNBVEVEJlJvbGVOYW1lPVVOS05PV04mUHJpbWFyeUdyb3VwSWQ9VU5BVVRIRU5USUNBVEVEJlByaW1hcnlHcm91cE5hbWU9VU5LTk9XTiZFbWFpbD1hZG1pbkBtYW55d2hvLmNvbSZJZGVudGl0eVByb3ZpZGVyPU5PTkUmVGVuYW50TmFtZT1VTktOT1dOJlRva2VuPU5PTkUmVXNlcm5hbWU9JlVzZXJJZD1QVUJMSUNfVVNFUiZGaXJzdE5hbWU9Jkxhc3ROYW1lPQ%3D%3D", result.getManyWhoToken());
        assertEquals(UUID.fromString("52df1a90-3826-4508-b7c2-cde8aa5b72cf"), result.getManyWhoUserId());
        assertEquals("UNAUTHENTICATED", result.getPrimaryGroupId());
        assertEquals("UNKNOWN", result.getPrimaryGroupName());
        assertEquals("UNAUTHENTICATED", result.getRoleId());
        assertEquals("UNKNOWN", result.getRoleName());
        assertEquals("UNKNOWN", result.getTenantName());
        assertEquals("NONE", result.getToken());
        assertEquals("", result.getUsername());
        assertEquals("PUBLIC_USER", result.getUserId());
    }

    @Test
    public void testEncode() {
        AuthenticatedWho authenticatedWho = new AuthenticatedWho();
        authenticatedWho.setDirectoryId("UNAUTHENTICATED");
        authenticatedWho.setDirectoryName("UNKNOWN");
        authenticatedWho.setEmail("admin@manywho.com");
        authenticatedWho.setFirstName("");
        authenticatedWho.setIdentityProvider("NONE");
        authenticatedWho.setLastName("");
        authenticatedWho.setManyWhoTenantId(UUID.fromString("aa606806-642f-4d3b-8a0b-9c06e0a7a7c4"));
        authenticatedWho.setManyWhoToken("TWFueVdob1RlbmFudElkPWFhNjA2ODA2LTY0MmYtNGQzYi04YTBiLTljMDZlMGE3YTdjNCZNYW55V2hvVXNlcklkPTUyZGYxYTkwLTM4MjYtNDUwOC1iN2MyLWNkZThhYTViNzJjZiZNYW55V2hvVG9rZW49RFVNTVkmRGlyZWN0b3J5SWQ9VU5BVVRIRU5USUNBVEVEJkRpcmVjdG9yeU5hbWU9VU5LTk9XTiZSb2xlSWQ9VU5BVVRIRU5USUNBVEVEJlJvbGVOYW1lPVVOS05PV04mUHJpbWFyeUdyb3VwSWQ9VU5BVVRIRU5USUNBVEVEJlByaW1hcnlHcm91cE5hbWU9VU5LTk9XTiZFbWFpbD1hZG1pbkBtYW55d2hvLmNvbSZJZGVudGl0eVByb3ZpZGVyPU5PTkUmVGVuYW50TmFtZT1VTktOT1dOJlRva2VuPU5PTkUmVXNlcm5hbWU9JlVzZXJJZD1QVUJMSUNfVVNFUiZGaXJzdE5hbWU9Jkxhc3ROYW1lPQ%3D%3D");
        authenticatedWho.setManyWhoUserId(UUID.fromString("52df1a90-3826-4508-b7c2-cde8aa5b72cf"));
        authenticatedWho.setPrimaryGroupId("UNAUTHENTICATED");
        authenticatedWho.setPrimaryGroupName("UNKNOWN");
        authenticatedWho.setRoleId("UNAUTHENTICATED");
        authenticatedWho.setRoleName("UNKNOWN");
        authenticatedWho.setTenantName("UNKNOWN");
        authenticatedWho.setToken("NONE");
        authenticatedWho.setUsername("");
        authenticatedWho.setUserId("PUBLIC_USER");

        String result = authorizationEncoder.encode(authenticatedWho);

        assertEquals(ENCODED, result);
    }
}
