package socialmedia;

import java.util.HashSet;
import java.util.Set;

public class User {

    private String username;
    private Set<User> followers = new HashSet<>();
    private Set<User> following = new HashSet<>();

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    // Subscribe (Follow another user)
    public void subscribe(User other) {
        other.followers.add(this);
        this.following.add(other);
        System.out.println(username + " subscribed to " + other.username);
    }

    // Unsubscribe
    public void unsubscribe(User other) {
        other.followers.remove(this);
        this.following.remove(other);
        System.out.println(username + " unsubscribed from " + other.username);
    }

    // Post a message
    public void postMessage(String message) {
        System.out.println("\n📢 " + username + " posted: " + message);
        notifyFollowers(message);
    }

    // Notify all followers
    private void notifyFollowers(String message) {
        for (User follower : followers) {
            follower.receiveNotification(this, message);
        }
    }

    // Receive notification
    public void receiveNotification(User from, String message) {
        System.out.println("🔔 " + username + " received message from " + from.getUsername() + ": " + message);
    }
}
