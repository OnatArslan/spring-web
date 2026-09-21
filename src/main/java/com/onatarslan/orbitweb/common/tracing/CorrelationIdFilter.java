package com.onatarslan.orbitweb.common.tracing;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
public class CorrelationIdFilter extends OncePerRequestFilter {

    public static final String REQUEST_ID_HEADER =
            "X-Request-Id";

    public static final String REQUEST_ID_MDC_KEY =
            "requestId";

    private static final Pattern VALID_REQUEST_ID =
            Pattern.compile("[A-Za-z0-9._:-]{1,128}");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestId = resolveRequestId(request);

        MDC.put(REQUEST_ID_MDC_KEY, requestId);

        response.setHeader(REQUEST_ID_HEADER, requestId);

        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(REQUEST_ID_MDC_KEY);
        }

    }


    public static Optional<String> getCorrelationId() {
        String correlationId = MDC.get(REQUEST_ID_MDC_KEY);

        return Optional.ofNullable(correlationId);
    }

    private String resolveRequestId(
            HttpServletRequest request
    ) {
        String incoming =
                request.getHeader(
                        REQUEST_ID_HEADER
                );

        if (incoming != null) {
            String candidate = incoming.trim();

            if (VALID_REQUEST_ID
                    .matcher(candidate)
                    .matches()) {
                return candidate;
            }
        }

        return UUID.randomUUID().toString();
    }


}
