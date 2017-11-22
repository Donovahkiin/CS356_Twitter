/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitorPattern;

import cs356_twitter.Group;
import cs356_twitter.User;

/** NOTE: This class finds the total number of tweets ever posted. 
 *      If a user posted a tweet when they had no followers, it will still be counted.
 *      If a user with multiple followers posted a tweet, it will only count once.
 *      There is no exception made for duplicate tweets (such as spamming). They are counted normally.
 */

public class TweetPositivePercentage implements Visitor
{
    private double positiveTotal = 0.00;
    private double tweetTotal = 0;
    
    @Override
    public void atGroup(Group e) {}         // do nothing

    @Override
    public void atUser(User e) {
        int size = e.getTweetsSize();
        tweetTotal += size;

        for (int i = 0; i < size; i++) // for every tweet
        {
            String[] matches = new String[]{"happy", "good", "great", "excellent"};

            for (String s : matches) {      // for every keyword we're searching for
                if (e.getTweet().contains(s)) {
                    positiveTotal += 1;
                    break;  // only one match is needed to be considered a "positive" tweet
                }
            }
        }
    }

    public double returnTotal() {
        return (positiveTotal / tweetTotal);
    }
    
}
