package designpattern.creational.abstractfactory;

public class AbstractFactoryExample {

    // Abstract Products
    interface Button {
        void render();
    }

    interface Checkbox {
        void render();
    }

    // Concrete Products for Windows
    static class WindowsButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering Windows button");
        }
    }

    static class WindowsCheckbox implements Checkbox {
        @Override
        public void render() {
            System.out.println("Rendering Windows checkbox");
        }
    }

    // Concrete Products for macOS
    static class MacOSButton implements Button {
        @Override
        public void render() {
            System.out.println("Rendering macOS button");
        }
    }

    static class MacOSCheckbox implements Checkbox {
        @Override
        public void render() {
            System.out.println("Rendering macOS checkbox");
        }
    }

    // Abstract Factory
    interface GUIFactory {
        Button createButton();

        Checkbox createCheckbox();
    }

    // Concrete Factories
    static class WindowsFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new WindowsButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new WindowsCheckbox();
        }
    }

    static class MacOSFactory implements GUIFactory {
        @Override
        public Button createButton() {
            return new MacOSButton();
        }

        @Override
        public Checkbox createCheckbox() {
            return new MacOSCheckbox();
        }
    }

    public static void main(String[] args) {
        // Create Windows GUI
        GUIFactory windowsFactory = new WindowsFactory();
        Button windowsButton = windowsFactory.createButton();
        Checkbox windowsCheckbox = windowsFactory.createCheckbox();

        windowsButton.render();
        windowsCheckbox.render();

        // Create macOS GUI
        GUIFactory macFactory = new MacOSFactory();
        Button macButton = macFactory.createButton();
        Checkbox macCheckbox = macFactory.createCheckbox();

        macButton.render();
        macCheckbox.render();
    }
}
