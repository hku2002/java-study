package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Quiz1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        return readCsvLines().stream()
            .map(str -> str[1].replaceAll("\\s", ""))
            .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
            .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, Integer::sum));
    }

    // 1.2 각 취미별 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        return readCsvLines().stream()
            .filter(str -> str[0].startsWith("정"))
            .map(str -> str[1].replaceAll("\\s", ""))
            .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
            .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldKey, newKey) -> newKey += oldKey));
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        return readCsvLines().stream()
            .map(str -> str[2])
            .map(str -> countContains(str, "좋아"))
            .reduce(0, Integer::sum);
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

    private int countContains(String text, String checkWord) {
        int start = 0;
        int end = checkWord.length();
        int total = 0;

        for (int i=0; i<text.length()-1; i++) {
            String temp = text.substring(start, end);
            if (checkWord.equals(temp)) total++;
            if (i < text.length() -1) {
                start++;
                end++;
            }
        }

        return total;
    }

}
