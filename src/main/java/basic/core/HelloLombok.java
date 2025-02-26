package basic.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("홍길동");
        helloLombok.setAge(10);

        System.out.println("helloLombok = " + helloLombok);
        System.out.println("helloLombok.getName() = " + helloLombok.getName());
        System.out.println("helloLombok.getAge() = " + helloLombok.getAge());
    }
}
