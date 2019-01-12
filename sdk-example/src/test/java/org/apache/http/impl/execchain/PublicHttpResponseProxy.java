package org.apache.http.impl.execchain;

import org.apache.http.HttpResponse;

/**
 * This is required to make it easier to create an instance of CloseableHttpResponse, which AbstractHttpClient needs,
 * which Rest Assured needs (for now - https://github.com/rest-assured/rest-assured/issues/497).
 */
public class PublicHttpResponseProxy extends HttpResponseProxy {
    public PublicHttpResponseProxy(HttpResponse response) {
        super(response, null);
    }
}
