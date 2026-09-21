package com.onatarslan.orbitweb.common.tracing;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class HandlerLoggingInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(HandlerLoggingInterceptor.class);


    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) {

        if (handler instanceof HandlerMethod handlerMethod) {
            log.debug(
                    "Resolved handler controller={} method={}",
                    handlerMethod.getBeanType().getSimpleName(),
                    handlerMethod.getMethod().getName()
            );
        }
        return true;
    }

}
