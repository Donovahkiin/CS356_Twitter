/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356_twitter;

import visitorPattern.Visitor;

public interface Selectable {
    public boolean isInGroup();
    public void joinedGroup();
    public void accept(Visitor v);
}
