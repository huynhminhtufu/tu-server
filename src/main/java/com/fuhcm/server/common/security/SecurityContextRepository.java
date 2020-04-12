package com.fuhcm.server.common.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.context.ServerSecurityContextRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class SecurityContextRepository implements ServerSecurityContextRepository {
  private final AuthenticationManager authenticationManager;

  @Override
  public Mono<Void> save(final ServerWebExchange exchange, final org.springframework.security.core.context.SecurityContext context) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Mono<SecurityContext> load(ServerWebExchange swe) {
    val request = swe.getRequest();
    val authHeader = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      val authToken = authHeader.substring(7);
      val auth = new UsernamePasswordAuthenticationToken(authToken, authToken);
      return authenticationManager.authenticate(auth).map(SecurityContextImpl::new);
    } else {
      return Mono.empty();
    }
  }
}