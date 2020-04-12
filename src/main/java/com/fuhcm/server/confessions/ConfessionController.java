package com.fuhcm.server.confessions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/confessions")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class ConfessionController {
  private final ConfessionService confessionService;

  @GetMapping
  private Flux<Confession> getAll() {
    return confessionService.getAll();
  }

  @PostMapping
  private Mono<Confession> create(@RequestBody Confession confession) {
    return confessionService.insert(confession);
  }
}
