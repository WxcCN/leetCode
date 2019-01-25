package core;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Nova wangxingchen
 * @date 2019/1/22
 */
public class Invoke {

    public static void main(String[] args) {
        try {
            Person p1 = new Person();
            Class<? extends Person> aClass = p1.getClass();
            Class<Person> personClass = Person.class;
            Class<?> aClass1 = Class.forName("core.Person");


            System.out.println(aClass.getName());

            Field nameField = aClass.getDeclaredField("name");
            System.out.println(nameField.getName());

            Person person = new Person("luoxn28", 23);
            Class clazz = person.getClass();

            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                String key = field.getName();
                PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
                Method method = descriptor.getReadMethod();
                Object value = method.invoke(person);

                System.out.println(key + ":" + value);

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Person {
    //私有属性
    private String name = "Tom";
    //公有属性
    public int age = 18;
    //构造方法
    public Person() {
    }

    public Person(String s, int i) {
        this.name = s;
        this.age = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //私有方法
    private void say(){
        System.out.println("private say()...");
    }
    //公有方法
    public void work(){
        System.out.println("public work()...");
    }
}
