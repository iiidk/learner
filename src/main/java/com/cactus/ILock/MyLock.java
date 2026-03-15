package com.cactus.ILock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyLock {
    public static class Sync extends AbstractQueuedSynchronizer {
        protected boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        protected boolean tryRelease(int releases) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}
