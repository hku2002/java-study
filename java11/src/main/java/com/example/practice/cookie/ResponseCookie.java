package com.example.practice.cookie;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.time.Duration;

@Getter
@Builder
public final class ResponseCookie {

    private final Duration maxAge;

    @Nullable
    private final String domain;
    private final String path;
    private final boolean secure;
    private final boolean httpOnly;
    @Nullable
    private final String sameSite;

    public ResponseCookie(Duration maxAge, @Nullable String domain, String path, boolean secure, boolean httpOnly, @Nullable String sameSite) {
        this.maxAge = maxAge;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.sameSite = sameSite;
    }

}
