package com.example.practice.optional;

import java.util.Optional;

public class OfflineClass {

    private Long id;
    private String title;
    private boolean closed;
    private Progress progress;

    public OfflineClass(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Progress getNonOptionalProgress() {
        return progress;
    }

    public Optional<Progress> getOptionalProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

}
