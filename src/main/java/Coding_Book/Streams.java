package Coding_Book;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        List<Integer>li= Arrays.asList(1,2,2,3,4,6,6,7,7);
//        li.stream().distinct().forEach((temp)-> System.out.println(temp));

        System.out.println(li.stream().filter((i)-> Collections.frequency(li,i)>1).distinct().collect(Collectors.toList()));
    }
}
