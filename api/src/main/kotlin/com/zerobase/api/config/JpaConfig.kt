package com.zerobase.api.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories("com.zerobase.domain.repository")
@EntityScan("com.zerobase.domain.domain")
class JpaConfig {
}