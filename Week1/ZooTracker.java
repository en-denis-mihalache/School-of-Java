
public class ZooTracker {

    
    public static abstract class Animal implements Comparable<Animal> {
        public String getName() {
            return getClass().getSimpleName();
        }

        public abstract void speak();

       
        public void feed() {
            String food = switch (this) {
                case Lion l   -> "meat";
                case Parrot p -> "seeds";
                case Snake s  -> "rodents";
                default       -> "unknown";
            };
            System.out.println(getName() + " eats " + food);
        }


        @Override
        public int compareTo(Animal other) {
            return this.getName().compareToIgnoreCase(other.getName());
        }
    }

    
    public static class Lion extends Animal {
        @Override public void speak() { System.out.println("Roar!"); }
    }
    public static class Parrot extends Animal {
        @Override public void speak() { System.out.println("Squawk!"); }
    }
    public static class Snake extends Animal {
        @Override public void speak() { System.out.println("Hiss!"); }
    }

    public static void main(String[] args) {
        
        Animal[] animals = { new Snake(), new Parrot(), new Lion() };
        java.util.Arrays.sort(animals);

        for (Animal a : animals) {
            a.feed();
            a.speak();
        }
    }
}
