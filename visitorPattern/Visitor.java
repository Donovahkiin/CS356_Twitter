package visitorPattern;

import cs356_twitter.Group;
import cs356_twitter.User;

public interface Visitor {
    public void atGroup(Group e);
    public void atUser(User e);
}
