//package com.sapo.team03.MCRM.Security.Filters;
//
//import java.io.IOException;
//import java.util.Collections;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import com.sapo.team03.MCRM.Model.Staff;
//import com.sapo.team03.MCRM.Security.Service.TokenAuthenticationService;
//
///**
// * Created by nhs3108 on 29/03/2017.
// */
//public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
//    public JWTLoginFilter(String url, AuthenticationManager authManager) {
//        super(new AntPathRequestMatcher(url));
//        setAuthenticationManager(authManager);
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
//        Staff credentials = new Staff(request.getParameter("email"), request.getParameter("password"));
//        return getAuthenticationManager().authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        credentials.getEmail(),
//                        credentials.getPassword(),
//                        Collections.emptyList()
//                )
//        );
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
//        TokenAuthenticationService.addAuthentication(response, authResult.getName());
//    }
//}
