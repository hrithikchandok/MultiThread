package Coding_Book;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Q2 {

    // sort the elmployee list


    public static void main(String[] args) {

        List<Employee> li=new ArrayList<>();

        li.add(new Employee(10,11,"rithik"));
        li.add(new Employee(70,24,"rithika"));
        li.add(new Employee(100,1,"Bharti"));
        li.add(new Employee(100,1,"Bharti"));
        li.add(new Employee(100,1,"Bharti"));
        li.add(new Employee(100,1,"Bharti"));


        li.stream().sorted((Employee e1, Employee e2)->e2.sal- e1.sal).forEach((temp)-> System.out.println(temp.name));

         // Highest Salary

        Employee first = li.stream().sorted((Employee e1, Employee e2) -> e2.sal - e1.sal).findFirst().orElse(null);
        System.out.println(first.name);

        li.stream().filter((temp)->temp.age>1).sorted((e1,e2)->e1.name.compareTo(e2.name)).forEach((temp)-> System.out.println(temp.name));


        List<Integer>li2= Arrays.asList(1,2,3,4,5,6,7,8,1,2);
        double v = li2.stream()
                .filter((n) -> n % 2 == 0)
                .mapToDouble(n -> n)
                .average()
                .orElse(0);

        li2.stream().filter(n->Collections.frequency(li2,n)>1).distinct().forEach(s-> System.out.println("Duplicate"+s));

        int sum = li2.stream().mapToInt(n -> n).sum();
        System.out.println("sum"+sum);

        System.out.println("Average "+v);

        List<String>ans=Arrays.asList("hrithik1232","dhall","chandok");

        ans.stream().sorted((s1,s2)->s1.length()-s2.length()).forEach(((ele)-> System.out.println(ele)));

        // group by depart

        List<Student>temp=new ArrayList<>();
        temp.add(new Student("Computer",101,"Moradabad"));
        temp.add(new Student("Electrical",301,"Noida"));
        temp.add(new Student("Physics",401,"Moradabad"));
        temp.add(new Student("Computer",501,"New Delhi"));

//        IMPORTANT
        Map<String, Long> collect = temp.stream().collect(groupingBy(Student::getDepartment, Collectors.counting()));
        System.out.println(collect);

        // filter on the bases of location and sort on the bases of name

        String loc="Moradabad";
        temp.stream().filter((ele)->ele.location.equalsIgnoreCase(loc)).sorted((s1,s2)->s1.id-s2.id).forEach((ele)-> System.out.println(ele.Department));

        // Find the occurrence of names of employees from the
        //List<Employee>, and find the frequency of each name.

        Map<String, Long> collect1 = li.stream().collect(groupingBy(Employee::getName, Collectors.counting()));
        System.out.println(collect1);


        String ars="1mbnmads132123";
        char arr[]=ars.toCharArray();
        System.out.println(arr);
       List<Character>lc=new ArrayList<>();

//       for(int i=0;i<arr.length;i++)
//       {
//           lc.add(arr.get(i));
//       }


//        Write a program to find the occurrence of each word in a given
//        string in java?

        String words="hello hrithik , this is me hrithik , whats up hrithik , you are on your own hrithik";
        List<String> list = Arrays.asList(words.split(" "));
        Map<String, Long> collect2 = list.stream().collect(groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect2);

//        String ans12="abcdabcdefhg";
//        char[] charArray = ans12.toCharArray();
//        List<char[]> temp12= Collections.unmodifiableList(new ArrayList<>(Arrays.asList(charArray)));
//        ans12.chars().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

    }








}

class Employee
{
    int sal;
    int age;

    public int getSal() {
        return sal;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    String name;

    Employee(int sal,int age,String name)
    {
        this.sal=sal;
        this.age=age;
        this.name=name;
    }


}
class Student
{
    String Department;
    int id;

    public String getDepartment() {
        return Department;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    String location;

    public Student(String department, int id, String location) {
        Department = department;
        this.id = id;
        this.location = location;
    }
}


