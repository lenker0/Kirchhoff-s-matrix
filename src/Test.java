public class Test {
    public static void main(String args[]) {

        Kirchhoffs kirchhoffs = new Kirchhoffs();

        System.out.println("Пример один - неориентированный граф 1: ");
        kirchhoffs.tessCase1();
        System.out.println();

        System.out.println("Пример два - неориентированный граф 2: ");
        kirchhoffs.tessCase2();
        System.out.println();

        System.out.println("Пример три - несвязный граф: ");
        kirchhoffs.tessCase3();
        System.out.println();

        System.out.println("Пример четыре - ориентированный граф: ");
        kirchhoffs.tessCase4();
        System.out.println();

        // В полном графе количество остово = n^(n-2)
        System.out.println("Пример пять - полный граф: ");
        kirchhoffs.tessCase5();
    }
}
