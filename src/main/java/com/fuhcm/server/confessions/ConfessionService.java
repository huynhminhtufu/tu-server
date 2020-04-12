package com.fuhcm.server.confessions;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfessionService {
  private final ConfessionRepository confessionRepository;

  public Flux<Confession> getAll() {
    return confessionRepository.findAll();
  }

  public Mono<Confession> insert(final Confession confession) {
    val entity = Confession.builder()
            .content(confession.getContent())
            .senderToken(confession.getSenderToken())
            .note(confession.getNote())
            .build();

    return confessionRepository.save(entity);
  }
}
