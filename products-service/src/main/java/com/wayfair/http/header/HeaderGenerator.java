package com.wayfair.http.header;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;

public class HeaderGenerator {
    public HttpHeaders getHeadersForSuccessGetMethod() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        return httpHeaders;
    }

    public HttpHeaders getHeadersForError() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/problem+json; charset=UTF-8");
        return httpHeaders;
    }

    public HttpHeaders getHeadersForSuccessPostMethod(HttpServletRequest request, String newResourceId) {
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            httpHeaders.setLocation(new URI(request.getRequestURI() + "/" + newResourceId));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
        return httpHeaders;
    }
}

