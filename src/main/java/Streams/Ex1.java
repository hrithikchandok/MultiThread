package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex1 {

    // count how many sal greater than x

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(10000);
        li.add(30000);
        li.add(40000);
        li.add(50000);
        li.add(60000);
//        System.out.println(li.stream().filter((temp)->temp>30000).map((temp)->temp/200).collect(Collectors.toList()));
//        System.out.println(li.stream().filter((temp)->temp>30000).count());


//        filter would lamda exper of predicate functal interface
//        map would take lambda exper of consumer funcitonsla interdface

//        three steps
//                create a stream
//                intermidate operation
//                Terminal oper

//creation of strems
//                colleciton.stream()
//                Arrays.stream([])
//                 Stream.of()


//      Diff Intermediate operation
//        we can chain these

//        filter->predicate
//        map-> function
//        Flat map->
//        distinct
//        sorted
//          peek
//        limit
//        skip
//        maptoint


        List<List<String>>li2=new ArrayList<>();
        li2.add(Arrays.asList("this","is","me"));
        li2.add(Arrays.asList("Who","Is","This"));
        li2.add(Arrays.asList("Hrithik?"));

        Stream<String>stream=li2.stream().flatMap((List<String>st)->st.stream());
        System.out.println(stream.collect(Collectors.toList()));


        Stream<Integer> limit = li.stream().limit(3);
        limit.peek((temp)-> System.out.println("LIMIT"+temp)).count();

        Stream<Integer> skip = li.stream().skip(3);
        skip.peek((temp)-> System.out.println("SKIp"+temp)).count();




//        why Lazy
//        w/o terminal it will not work




//        Terminal
//               for each
//               toArray
//               reduce
//               count
//               collect
//               min
//               max
//               anyMatch
//               allMatch
//               noneMatch
//               findFirst
//               findAny


//        Once a terminal operation consumed one stream that stream gets closes and cant be used again

//        parallel stream
//          use fork join algo  (merge algorithm diagram )


        long l = System.currentTimeMillis();
        li.stream().map((val)->val*val).forEach((temp)-> System.out.println(temp));
        System.out.println("time in stream ->"+ (System.currentTimeMillis()-l));
        long l1=System.currentTimeMillis();
        li.parallelStream().map((val)->val*val).forEach((temp)-> System.out.println(temp));
        System.out.println("time in Pallel stream ->"+ (System.currentTimeMillis()-l1));

     }



}
