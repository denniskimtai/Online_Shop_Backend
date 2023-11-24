package com.dennis.onlineshopinterview.api.security;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.dennis.onlineshopinterview.exception.UserExistsException;
import com.dennis.onlineshopinterview.model.Customer;
import com.dennis.onlineshopinterview.repository.UserRepository;
import com.dennis.onlineshopinterview.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class JWTRequestFilter extends OncePerRequestFilter {
    @Autowired
    JWTService jwtService;
    @Autowired
    UserRepository userRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenHeader = request.getHeader("Authorization");
        if(tokenHeader != null && tokenHeader.startsWith("Bearer ")){
            String token = tokenHeader.substring(7);
            try {
                String userId = jwtService.getUserId(token);
                Optional<Customer> opCustomer = userRepository.findById(UUID.fromString(userId));
                if(opCustomer.isPresent()){
                    Customer customer = opCustomer.get();
                    UsernamePasswordAuthenticationToken authenticationToken = new
                            UsernamePasswordAuthenticationToken(customer, null, new ArrayList<>());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }catch (JWTDecodeException ex){
            }
        }
        filterChain.doFilter(request, response);
    }
}
