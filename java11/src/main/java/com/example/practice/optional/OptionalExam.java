package com.example.practice.optional;

import java.util.Optional;

public class OptionalExam {

    public static void main(String[] args) {
        OfflineClass offlineClass = new OfflineClass(1L, "Spring boot", true);

        // 옵셔널 사용
        Optional<Progress> optionalProgress = offlineClass.getOptionalProgress();
        System.out.println(optionalProgress.isPresent());

        try {
            // 옵셔널 미사용
            Progress nonOptionalProgress = offlineClass.getNonOptionalProgress();
            System.out.println(nonOptionalProgress.getStudyDuration());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
