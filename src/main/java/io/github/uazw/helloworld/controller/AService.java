package io.github.uazw.helloworld.controller;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.springframework.stereotype.Service;

@Service
public class AService {

    private static final Tracer tracer = io.opentelemetry.api.GlobalOpenTelemetry
            .getTracer("io.github.uazw.helloworld.AService");

    public void serve() {
        Span span = tracer.spanBuilder("AService.serve")
                .setSpanKind(SpanKind.INTERNAL)
                .startSpan();
        try (Scope scope = span.makeCurrent()) {
            // Your business logic here
            System.out.println("AService is serving.");

            // Example attribute and event
            span.setAttribute("service.step", "start");
            span.addEvent("doing-work");

            // Simulate work or call other methods here
        } catch (Exception e) {
            span.recordException(e);
            span.setStatus(StatusCode.ERROR, e.getMessage());
            throw e;
        } finally {
            span.end();
        }
    }
}
