abstract class Pizza {
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract double cost();
}

class MargaritaPizza extends Pizza {
    public MargaritaPizza() {
        description = "Margarita Pizza";
    }
    @Override
    public double cost() {
        return 6.99;
    }
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        description = "Pepperoni Pizza";
    }
    @Override
    public double cost() {
        return 8.99;
    }
}

abstract class PizzaDecorator extends Pizza {
    public abstract String getDescription();
}

class CheeseDecorator extends PizzaDecorator {
    private Pizza pizza;
    public CheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }
    @Override
    public double cost() {
        return pizza.cost() + 1.50;
    }
}

class MushroomDecorator extends PizzaDecorator {
    private Pizza pizza;
    public MushroomDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }
    @Override
    public double cost() {
        return pizza.cost() + 2.00;
    }
}

public class PizzaOrder {
    public static void main(String[] args) {
        Pizza margarita = new MargaritaPizza();
        System.out.println("Ordered: " + margarita.getDescription() + " - Cost: $" + margarita.cost());

        Pizza pepperoniWithCheese = new CheeseDecorator(new PepperoniPizza());
        System.out.println("Ordered: " + pepperoniWithCheese.getDescription() + " - Cost: $" + pepperoniWithCheese.cost());

        Pizza mushroomPepperoniWithCheese = new MushroomDecorator(pepperoniWithCheese);
        System.out.println("Ordered: " + mushroomPepperoniWithCheese.getDescription() + " - Cost: $" + mushroomPepperoniWithCheese.cost());
    }
}