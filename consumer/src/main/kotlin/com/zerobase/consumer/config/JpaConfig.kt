package com.zerobase.consumer.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories("com.zerobase.domain.repository")
@EntityScan("com.zerobase.domain.domain")
@Configuration
class JpaConfig