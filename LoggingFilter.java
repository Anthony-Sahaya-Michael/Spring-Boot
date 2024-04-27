package com.example.onetomanyuniauthor.requestrespone;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilter extends OncePerRequestFilter {

   private static final Logger logger=LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                //wrap the request and response, allowing their content to be cached and read multiple times
                ContentCachingRequestWrapper contentCachingRequestWrapper=new ContentCachingRequestWrapper(request);
                ContentCachingResponseWrapper contentCachingResponseWrapper =new ContentCachingResponseWrapper(response);
                long startTime=System.currentTimeMillis();

                //method used in a servlet filter to pass the request and response to the next filter in the chain
                filterChain.doFilter(contentCachingRequestWrapper, contentCachingResponseWrapper);
                long timeTaken= System.currentTimeMillis()-startTime;

                //convert request body and response body to String
                String requestBody=getStringValue(contentCachingRequestWrapper.getContentAsByteArray(),request.getCharacterEncoding());
                String responseBody=getStringValue(contentCachingResponseWrapper.getContentAsByteArray(), response.getCharacterEncoding());
                
                //loggermethod
                logger.info("Filter Logs: METHOD= {}; REQUESTURI= {};REQUESTBODY= {}; RESPONSE CODE= {}; RESPONSE BODY= {}; TIME TAKEN= {} ",
                request.getMethod(),request.getRequestURI(),requestBody,response.getStatus(),responseBody,timeTaken);
                
                contentCachingResponseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentAsByteArray, String characterEncoding) {
        try {
            return new String(contentAsByteArray,0,contentAsByteArray.length,characterEncoding);
        } catch (UnsupportedEncodingException e) {
           
            e.printStackTrace();
        }
        return "";
       
    }
    
}
