package designpattern.creational.factory;

public class FactoryPatternExample {

    interface Product {
        void display();
    }

    static class ConcreteProductA implements Product {
        @Override
        public void display() {
            System.out.println("Product A");
        }
    }

    static class ConcreteProductB implements Product {
        @Override
        public void display() {
            System.out.println("Product B");
        }
    }

    static class ProductFactory {
        public Product createProduct(String type) {
            if (type.equalsIgnoreCase("A")) {
                return new ConcreteProductA();
            } else if (type.equalsIgnoreCase("B")) {
                return new ConcreteProductB();
            }
            throw new IllegalArgumentException("Unknown product type");
        }
    }

    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();

        Product productA = factory.createProduct("A");
        productA.display();

        Product productB = factory.createProduct("B");
        productB.display();
    }
}
