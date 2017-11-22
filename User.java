package cs356_twitter;

import java.util.List;
import java.util.ArrayList;
import observerPattern.Observer;
import observerPattern.Subject;
import visitorPattern.Visitor;

public class User extends Subject implements Observer, Selectable{
    
  //  private String ID;
    private boolean inGroup = false;
    private boolean hasWindow = false;
    private UserView userWindow;
    private String feed = "";
    private long creationTime;
    private long lastUpdateTime;
    
    private List<Subject> subscriptions = new ArrayList<Subject>();
    
    public User(String input) 
    {
        ID = input;     // this changes the ID in Subject superclass
        creationTime = System.currentTimeMillis();
        lastUpdateTime = System.currentTimeMillis();
    }

    /** Group/User objects will be used as tree nodes; override toString so it
    *  returns the string we want to display at that node. */
    @Override
    public String toString() {
        return ID;
    }
    
    @Override
    public boolean addSubscription(Subject subject) {
        if(!subscriptions.contains(subject)) {       // if this user isn't already following them
            subscriptions.add(subject);
            subject.addFollower(this);
            return true;    // confirm that an add was successful
        } else
            return false;
    }

    @Override
    public void update(Subject subject) {
        feed = subject.getID() + ": ";
        feed += subject.getTweet() + "\n";
        lastUpdateTime = System.currentTimeMillis();
        userWindow.updateNewsFeed(feed);
    }
    
    public String getFeed() {
        return feed;
    }
    
    public boolean isInGroup() {
        return inGroup;
    }
    
    public void joinedGroup() {
        inGroup = true;
    }
    
    public boolean hasWindow() {
        return hasWindow;
    }
    
    public void setWindow(UserView newUserView) {
        userWindow = newUserView;
    }
    
    public UserView getWindow() {
        return userWindow;
    }
    
    public void accept(Visitor v) {
        v.atUser(this);
    }
    
    public long getCreationTime() {
        return creationTime;
    }
    
    public long getLastUpdateTime() {
        return lastUpdateTime;
    }
}