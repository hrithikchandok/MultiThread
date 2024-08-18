package LockFreeConcurency;

public class Main {

//    two ways of achiving the concuerny
//            LockBased mechenaism -> Synchronised , Stamped , reentrant , readwrite
//            LockFree mechanism->CAS(Compare&Swap) theory-> Atomic IOntegre, AtomicBoolean,AtomicLong

//    LockFree is Faster than LockBased
//    The technique we can achive lock free is using CAS operation
//     optimistic Read of stamped one is also used CAS technique



//    CAS Tech
//            1-> its a low level operation
//            2-> low level bcoz handled by CPU
//            3-> its atomic
//            4->irrespective of core , only one can access it
//            5-> CAS operation is atomic
//            6-> CAS operation has 3 values
//            7->CAS(memory , expected value , new Value)
//            8-> it will load or read the data from memory
//            9-> it will compare the expected with the memory one
//            10-> IF IT MATCHES UPDATE TO NEW VALUE
//            ABA Problem can happen





    public static void main(String[] args) {

        LockBased src=new LockBased();
        LockFree src2=new LockFree();

        Thread t1 =new Thread(()->src2.increment());
        Thread t2=new Thread(()->src2.increment());
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(src2.getElement());




    }
}
