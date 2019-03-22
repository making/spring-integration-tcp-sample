package com.example.tcpclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;

@EnableIntegration
@Configuration
public class IntegrationConfig {

    private final TcpClientProps props;


    public IntegrationConfig(TcpClientProps props) {
        this.props = props;
    }

    @Bean
    public IntegrationFlow integrationFlow() {
        return f -> f.handle(Tcp.outboundGateway(Tcp.nioClient(this.props.getHost(), this.props.getPort())
            .serializer(TcpCodecs.crlf())
            .get()))
            .transform(Transformers.objectToString());
    }
}
