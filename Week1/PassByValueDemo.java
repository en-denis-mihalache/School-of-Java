public class PassByValueDemo {
    String name = "Original Name";
    int[] numbers = {1, 2, 3, 4, 5};
    public void modify(String name) {   
        this.name = "Modified Name";
    }
    public void modifyArray(int[] numbers) {
        if (numbers.length > 0) {
            numbers[0] = 99;
        }
    }  
    public static void main(String[] args) {
        PassByValueDemo demo = new PassByValueDemo();
        System.out.println("Before modify: " + demo.name);
        demo.modify(demo.name);
        System.out.println("After modify: " + demo.name);
        System.out.println("Before modifyArray: " + demo.numbers[0]);
        demo.modifyArray(demo.numbers);
        System.out.println("After modifyArray: " + demo.numbers[0]);
    } 
}
