package com.fuhcm.server.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
  private final UserRepository userRepository;

  public Flux<User> getAll() {
    return userRepository.findAll();
  }

  public Mono<User> insert(final User user) {
    val newUser = User.builder()
            .email(user.getEmail())
            .name(user.getName())
            .build();

    return userRepository.insert(newUser);
  }

  public Mono<User> getOne(final String id) {
    return userRepository.findUserById(id);
  }

  public Mono<User> setAdmin(final String id, final boolean isAdmin) {
    return Mono.just(id)
            .flatMap(userRepository::findUserById)
            .flatMap(u -> {
              u.setIsAdmin(isAdmin);
              return Mono.just(u);
            })
            .flatMap(userRepository::save);
  }
}
