package com.example.practice.optional;

import java.time.Duration;

public class Progress {

    private Duration studyDuration;
    private boolean isFinished;

    public Progress(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    public Duration getStudyDuration() {
        return studyDuration;
    }
}
