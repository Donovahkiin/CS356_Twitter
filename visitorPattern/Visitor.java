/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitorPattern;

import cs356_twitter.Group;
import cs356_twitter.User;

public interface Visitor {
    public void atGroup(Group e);
    public void atUser(User e);
}
