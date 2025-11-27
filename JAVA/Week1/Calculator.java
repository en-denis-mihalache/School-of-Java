public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public double add(double a, int b) {
        return a + b;
    }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Integer addition: " + calc.add(5, 10));
        System.out.println("Double addition: " + calc.add(5.5, 10.2));
        System.out.println("Mixed addition: " + calc.add(5.5, 10));
    }
}