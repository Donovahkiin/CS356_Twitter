package visitorPattern;

import cs356_twitter.Group;
import cs356_twitter.User;

/** NOTE: This class finds the total number of tweets ever posted. 
 *      If a user posted a tweet when they had no followers, it will still be counted.
 *      If a user with multiple followers posted a tweet, it will only count once.
 *      There is no exception made for duplicate tweets (such as spamming). They are counted normally.
 */

public class TweetTotalVisitor implements Visitor
{
    private int tweetTotal = 0;
    
    @Override
    public void atGroup(Group e) {}        // do nothng

    @Override
    public void atUser(User e) {
        tweetTotal += e.getTweetsSize();
    }

    public int returnTotal() {
        return tweetTotal;
    }
    
}
