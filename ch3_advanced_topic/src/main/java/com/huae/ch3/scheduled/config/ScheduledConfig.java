package com.huae.ch3.scheduled.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.huae.ch3.scheduled.*")
@EnableScheduling
public class ScheduledConfig {
}