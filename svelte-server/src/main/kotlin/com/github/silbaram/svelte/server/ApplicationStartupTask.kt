package com.github.silbaram.svelte.server

import com.github.silbaram.svelte.server.configuration.NettyServerTemplate
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationStartupTask(
    private val nettyServerConfigs: Map<String, NettyServerTemplate>
): ApplicationListener<ApplicationReadyEvent> {
    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        nettyServerConfigs.values.forEach(NettyServerTemplate::nettyServerStart)
    }
}