package com.fuhcm.server.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class UserController {
  private final UserService userService;

  @GetMapping("/all")
  public Flux<User> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{id}")
  public Mono<User> getById(@PathVariable final String id) {
    return userService.getOne(id);
  }

  @PostMapping("/signup")
  public Mono<User> signUp(@RequestBody final User user) {
    return userService.insert(user);
  }

  @PutMapping("/setup/{id}")
  public Mono<User> setupAdmin(@PathVariable final String id) {
    return userService.setAdmin(id, true);
  }
}
