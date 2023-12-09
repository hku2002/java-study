package com.example.practice.cookie;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.Duration;
import java.util.function.Consumer;

@Getter
@Setter
public class CookieWebSessionIdResolver {

    private String cookieName = "SESSION";
    private Duration cookieMaxAge = Duration.ofSeconds(-1);

    @Nullable
    private Consumer<ResponseCookie.ResponseCookieBuilder> cookieInitializer = null;

    public void addCookieInitializer(Consumer<ResponseCookie.ResponseCookieBuilder> initializer) {
        this.cookieInitializer = this.cookieInitializer != null ?
                this.cookieInitializer.andThen(initializer) : initializer;
    }

    public void expireSession() {
        ResponseCookie cookie = initSessionCookie("", Duration.ZERO);
    }

    public ResponseCookie initSessionCookie(String id, Duration maxAge) {
        ResponseCookie.ResponseCookieBuilder cookieBuilder = ResponseCookie.builder()
                .path("/test/path")
                .domain("www.second-domain.com")
                .maxAge(maxAge)
                .httpOnly(true)
                .secure(true)
                .sameSite("Lax");

        if (this.cookieInitializer != null) {
            this.cookieInitializer.accept(cookieBuilder);
        }

        return cookieBuilder.build();
    }

}
