package LockFreeConcurency;

public class LockBased
{

    int counter=0;

    synchronized void increment()
    {
        counter++;
//       counter++ is  is not a atomic operation
    }

    int getElement()
    {
         return counter;
    }


}
