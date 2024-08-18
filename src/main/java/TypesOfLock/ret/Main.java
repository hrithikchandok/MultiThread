package TypesOfLock.ret;

public class Main {
    public static void main(String[] args) {

         SharedRrc src=new SharedRrc();
         SharedRrc src2=new SharedRrc();// retrtangt lock

        SynchSrc synchSrc=new SynchSrc(); // syn lock
        SynchSrc synchSrc2=new SynchSrc(); // syn lock


         Thread t1=new Thread(()->src.producer());
         Thread t2=new Thread(()->src2.producer());

        Thread t3=new Thread(()->synchSrc.producer());
        Thread t4=new Thread(()-> synchSrc2.producer());

//        t1.start();
//        t2.start();

        t3.start();
        t4.start();



//        Notes diff between syncrhonised and reterant locking
//                1-> Synchronised locking apply monitor lock on the object
//                2-> if we pass the same object then it will prevent the other thread to access the smae code
//                3-> but if we pass diff objtec two monitor lock will be created and both can access the same code can lead to inconsitency
//                4-> _--------------------------vs Reterant locking ---------------------------------------------
//                5->in reternat locking if we want irrespective of object locking we will use this
//                6-> we can ignore starvation by unlocking the lock in some time which is not possible with synchronized
//
//
//        Custom lock
//                1-> this lock dont depend on Object
//                2-> types
//                    2.1->reterant lock
//                    2.2->Read&write lock
//                    2.3->Stamed Lock ->
//                            2.3.1->Normal read write lock
//                            2.3.2->optimistic read
//                    2.4->semaphore lock

    }
}
