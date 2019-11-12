package ue2;

public class Ork implements Runnable
{
    public Dagger leftDagger;
    public Dagger rightDagger;


    public Ork(Dagger leftDagger, Dagger rightDagger)
    {
        this.leftDagger = leftDagger;
        this.rightDagger = rightDagger;
    }

    @Override
    public void run()
    {
        while(true)
        {
            drinking();

            getRightDagger();
            getLeftDagger();

            feasting();

            releaseLeftDagger();
            releaseRightDagger();

        }

    }


    public void drinking()
    {
        int sleepTime = (int) (Math.random() * 300 + 100);

        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this+": Finished drinking!");

    }

    public void feasting()
    {
        int sleepTime = (int) (Math.random() * 1000 + 250);

        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(this+": Finished feasting!");

    }

    public void getRightDagger()
    {
        while(rightDagger.getOwner() != null && rightDagger.getRl().isLocked())
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        rightDagger.setOwner(this);
        rightDagger.getRl().lock();
        System.out.println(this+": My Right Dagger!");

    }

    public void getLeftDagger()
    {
        while(leftDagger.getOwner() != null && leftDagger.getRl().isLocked())
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        leftDagger.setOwner(this);
        leftDagger.getRl().lock();
        System.out.println(this+": My Left Dagger!");
    }

    public void releaseLeftDagger()
    {
        leftDagger.setOwner(null);
        leftDagger.getRl().unlock();
        System.out.println(this+": This Left Dagger is free!");
    }

    public void releaseRightDagger()
    {
        rightDagger.setOwner(null);
        rightDagger.getRl().unlock();
        System.out.println(this+": This Right Dagger is free!");
    }

}

