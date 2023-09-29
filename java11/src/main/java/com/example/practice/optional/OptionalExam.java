package com.example.practice.optional;

import java.util.List;
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

        List<OfflineClass> offlineClasses = List.of(
                new OfflineClass(1L, "Spring boot 2.0", true),
                new OfflineClass(2L, "Spring boot 3.0", true),
                new OfflineClass(3L, "rest api development", true)
        );

        // 옵셔널 받아오기
        OfflineClass optionalClass = offlineClasses.stream()
                .filter(offClass -> offClass.getTitle().startsWith("Spring"))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        System.out.println(optionalClass.getTitle());

    }

}
