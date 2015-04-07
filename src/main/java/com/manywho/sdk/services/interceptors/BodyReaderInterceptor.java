package com.manywho.sdk.services.interceptors;

import com.manywho.sdk.services.CachedData;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BodyReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        if (context.getInputStream().available() > 0) {
            IOUtils.copy(context.getInputStream(), outputStream);

            byte[] requestEntity = outputStream.toByteArray();

            CachedData.bodyStream = requestEntity;

            context.setInputStream(new ByteArrayInputStream(requestEntity));
        }

        return context.proceed();
    }
}
