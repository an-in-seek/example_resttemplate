package com.seek.community;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampleRestTemplateApplicationTests {

    @Test
    void contextLoads() {
        IntStream.rangeClosed(1, 1000)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);

        int[] arr = {5, 3, 8, 1, 2};
        Arrays.sort(arr); // 배열을 오름차순으로 정렬
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 5, 8]

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(2);

        Collections.sort(list); // 리스트를 오름차순으로 정렬
        System.out.println(list); // [1, 2, 3, 5, 8]
    }

}
