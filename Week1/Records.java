public class Records {
    public record Person(String name, int age) { }
    static Person person = new Person("Alice", 30);
    static Person person1 = new Person("Matt", 20);
    static Person person2 = new Person("Zoe", 25);
    public static void main(String[] args) {
        
        System.out.println("Name: " + person.name()+ ", Age: " + person.age());
        System.out.println("Name: " + person1.name()+ ", Age: " + person1.age());
        System.out.println("Name: " + person2.name()+ ", Age: " + person2.age());
        System.out.println(new Records().toString());

    }
    @Override
    public String toString() {
        return "Records{" +
                "person=" + person.name() +
                ", person1=" + person1.name() +
                ", person2=" + person2.name() +
                '}';
    }

}