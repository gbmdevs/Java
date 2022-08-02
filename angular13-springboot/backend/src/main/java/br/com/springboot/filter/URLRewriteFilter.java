package br.com.springboot.filter;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class URLRewriteFilter implements  Filter{

    private final String API_PATTERN = "^\\/api\\/(.+)$";
    private final String POINT_EXCLUSION_PATTERN = "^([^.]+)$";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String requestURI = servletRequest.getRequestURI();
        String contextPath = servletRequest.getContextPath();

        System.out.println("Request URI  :" + requestURI);
        System.out.println("Context Path :" + contextPath);

        if(!requestURI.equals(contextPath) &&
                !requestURI.matches(API_PATTERN) && // Check if the requested URL is not a controller (/api/**)
                    requestURI.matches(POINT_EXCLUSION_PATTERN) // Check if there are no "." in requested URL
        ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

}