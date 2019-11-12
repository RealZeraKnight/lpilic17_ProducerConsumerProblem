package ue2;

import java.util.concurrent.locks.ReentrantLock;

public class Dagger
{
    private ReentrantLock rl;
    private Ork owner;

    public Dagger() {
        this.rl = new ReentrantLock();
    }

    public Ork getOwner() {
        return owner;
    }

    public void setOwner(Ork owner) {
        this.owner = owner;
    }

    public ReentrantLock getRl() {
        return rl;
    }

}
