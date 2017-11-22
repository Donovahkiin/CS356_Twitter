package cs356_twitter;

import visitorPattern.Visitor;

public interface Selectable {
    public boolean isInGroup();
    public void joinedGroup();
    public void accept(Visitor v);
    public long getCreationTime();
}
