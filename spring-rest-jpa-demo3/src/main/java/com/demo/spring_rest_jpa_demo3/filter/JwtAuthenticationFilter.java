package com.demo.spring_rest_jpa_demo3.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.spring_rest_jpa_demo3.service.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;
  
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    	// take out the Authorization header from the request
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        
        // check if authHeader is not null and starts with Bearer
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
        	// cutting the Bearer from the front
            token = authHeader.substring(7);
            // extract username from the token
            username = jwtService.extractUsername(token);
            System.out.println("username : " + username);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.validateToken(token, userDetails)) {
            	System.out.println("token validated...");
                UsernamePasswordAuthenticationToken authToken = 
                		new UsernamePasswordAuthenticationToken
                			(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // telling spring security that this request is authenticated because 
                	//the token is verfied and this info is passed to spring security
                    //by setting the authToken in the SecurityContextHolder
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
