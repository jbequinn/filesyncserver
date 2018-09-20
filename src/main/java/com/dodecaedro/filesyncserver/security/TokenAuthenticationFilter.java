package com.dodecaedro.filesyncserver.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Slf4j
public class TokenAuthenticationFilter extends GenericFilterBean {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain filterChain) throws IOException, ServletException {

    String token = request.getParameter("key");
    AuthenticationToken authenticationToken = new AuthenticationToken(token);
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    filterChain.doFilter(request, response);
  }
}
