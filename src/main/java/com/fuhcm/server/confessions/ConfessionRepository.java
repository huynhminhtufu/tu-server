package com.fuhcm.server.confessions;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ConfessionRepository extends ReactiveMongoRepository<Confession, Long> {
}
