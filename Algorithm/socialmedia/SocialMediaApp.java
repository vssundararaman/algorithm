package socialmedia;

public class SocialMediaApp {
    public static void main(String[] args) {
        User alice = new User("Alice");
        User bob = new User("Bob");
        User charlie = new User("Charlie");

        bob.subscribe(alice);
        charlie.subscribe(alice);

        alice.postMessage("Hello, everyone! 👋");

        bob.unsubscribe(alice);
        alice.postMessage("Second post: Stay tuned!");
    }
}
