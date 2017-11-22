package cs356_twitter;

import cs356_twitter.User;
import java.util.ArrayList;
import java.util.List;
import visitorPattern.Visitor;

public class Group implements Selectable{    // extends user?
    
    private String ID;
    private boolean inGroup = false;
    private List<User> users = new ArrayList<User>();
    private List<Group> groups = new ArrayList<Group>();
    private long creationTime;
    
    public Group(String input) {
        ID = input;
        creationTime = System.currentTimeMillis();
    }
    
    /** Group/User objects will be used as tree nodes; override toString so it
     *  returns the string we want to display at that node. */
    @Override
    public String toString() {
        return ID;
    }
    
    public void addUser(User input) {   // ideally, this error will execute as a popup window.
        if(input.isInGroup()) {
            System.out.println("Error: a user may only be in one group. No change has been made.");
        }
        else {
            users.add(input);
        }
    }
    
    public void addGroup(Group input) {
        if (input.isInGroup()) {
            System.out.println("Error: this group has already been defined recursively. No change has been made.");
        }
        else {
            groups.add(input);
        }
    }
    
    public boolean isInGroup() {
        return inGroup;
    }
    
    public void joinedGroup() {
        inGroup = true;
    }
    
    public void accept(Visitor v) {
        v.atGroup(this);
    }
    
    public long getCreationTime() {
        return creationTime;
    }
}
