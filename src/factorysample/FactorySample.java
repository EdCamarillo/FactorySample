/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package factorysample;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
abstract class Burger {
    protected String name;

    public Burger(String name) {
        this.name = name;
    }

    public abstract void prepare();
    public abstract void cook();
    public abstract void assemble();
    public abstract void serve();
}

class MeatBurger extends Burger {
    public MeatBurger(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name + " by selecting quality meat.");
    }

    @Override
    public void cook() {
        System.out.println("Grilling the meat for the " + name + ".");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling the ingredients for the " + name + ".");
    }

    @Override
    public void serve() {
        System.out.println("Serving the delicious " + name + ".");
    }
}

class VeggieBurger extends Burger {
    public VeggieBurger(String name) {
        super(name);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name + " with fresh vegetables.");
    }

    @Override
    public void cook() {
        System.out.println("Cooking the veggie patty for the " + name + ".");
    }

    @Override
    public void assemble() {
        System.out.println("Assembling the ingredients for the " + name + ".");
    }

    @Override
    public void serve() {
        System.out.println("Serving the healthy " + name + ".");
    }
}

class BurgerFactory {
    public Burger createBurger(String burgerType) {
        if (burgerType.equalsIgnoreCase("Meat")) {
            return new MeatBurger("Meat Burger");
        } else if (burgerType.equalsIgnoreCase("Veggie")) {
            return new VeggieBurger("Veggie Burger");
        } else {
            return null; // Handle unknown burger types here
        }
    }
}

public class FactorySample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BurgerFactory burgerFactory = new BurgerFactory();

        System.out.print("Enter burger type (Meat or Veggie): ");
        String burgerType = scanner.nextLine();

        Burger burger = burgerFactory.createBurger(burgerType);

        if (burger != null) {
            System.out.println("Making a " + burger.name + ":");
            burger.prepare();
            burger.cook();
            burger.assemble();
            burger.serve();
        } else {
            System.out.println("Invalid burger type.");
        }

        scanner.close();
    }
}
