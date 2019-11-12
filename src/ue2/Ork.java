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
        int sleepTime = (int) (Math.random() * 100 + 1);

        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public void feasting()
    {
        int sleepTime = (int) (Math.random() * 250 + 1);

        try
        {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }

    public void getRightDagger()
    {
        while(rightDagger.getRl() != null && rightDagger.getRl().isLocked())
        {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        rightDagger.setOwner(this);
        rightDagger.getRl().lock();

    }

    public void getLeftDagger()
    {
        while(leftDagger.getRl() != null && leftDagger.getRl().isLocked())
        {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        leftDagger.setOwner(this);
        leftDagger.getRl().lock();
    }

    public void releaseLeftDagger()
    {
        leftDagger.setOwner(null);
        leftDagger.getRl().unlock();
    }

    public void releaseRightDagger()
    {
        rightDagger.setOwner(null);
        rightDagger.getRl().unlock();
    }

}

