package com.fuhcm.server.common.security;

import lombok.val;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {
  @Override
  public Mono<Authentication> authenticate(Authentication authentication) {
    val roles = Collections.singletonList(new SimpleGrantedAuthority("ADMIN"));

    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
            "testUsername",
            null, roles);
    return Mono.just(auth);
  }
}