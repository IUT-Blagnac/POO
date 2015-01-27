public class ThreadPCSynch {

   public static void main( String args[] )

   {

      SynchronizedData d = new SynchronizedData();

      Producer2 p = new Producer2( d );

      Consumer2 c = new Consumer2( d );

 

      p.start();

      c.start();

   }

}


 class SynchronizedData {

   private int commonInt = -1;

   private boolean blocked = false;

// 'blocked' means 'unwriteable' or 'readable' so set to 'true' if consumer can access

             // data and false if producer can access

 

   public synchronized void setCommonInt( int val )

   {

      

       while ( blocked ) {  // not the producer's turn

         try {

            wait(); 

         }

         catch ( InterruptedException e ) {

           System.err.println( e.toString() );

         }

      }

    

      String threadName = Thread.currentThread().getName();

       String str =  " Assigning as " + val ;

      System.out.print(threadName + str + "\n");

      

      commonInt = val;

      blocked = true;

      notify();  // tell a waiting thread to become ready

   }

 

   public  synchronized int getCommonInt()

   {

      

       while ( !blocked ) {  // not the consumers's turn

         try {

            wait(); 

         }

         catch ( InterruptedException e ) {

           System.err.println( e.toString() );

         }

     

      }

    

      String threadName = Thread.currentThread().getName();

       String str2 =  " Getting the " + commonInt ;

      System.out.print(threadName + str2 +"\n");

      blocked = false;

       notify();  // tell a waiting thread to become ready

      return commonInt;

   }

}

 



 class Consumer2 extends Thread {

   private SynchronizedData cHold;

 

   public Consumer2( SynchronizedData h )

   {

      super( "Consumer2" );

      cHold = h;

   }

 

   public void run()

   {

      int val, sum = 0;

 

      do {

         // sleep for a random interval

         try {

            Thread.sleep( (int) ( Math.random() * 2000 ) );

         }

         catch( InterruptedException e ) {

            System.err.println( e.toString() );

         }

 

         val = cHold.getCommonInt();

         sum += val;
         System.out.print( "   Thread " + getName() + " is at "+sum+ "\n");
      } while ( val != 10 );

      System.out.print( "Thread " + getName() + "Finished Getting values \n");

   }

}



class Producer2 extends Thread {

   private SynchronizedData pHold;

 

   public Producer2( SynchronizedData h )

   {

      super( "Producer2" );

      pHold = h;

   }

 

   public void run()

   {

      for ( int count = 1; count <= 10; count++ ) {

         try {

              Thread.sleep(1000);

         }

         catch( InterruptedException e ) {

            System.err.println( e.toString() );

         }

 

         pHold.setCommonInt( count );

      }

  

     

      

      System.out.print( "Thread " + getName() + "Finished Putting values \n");

     

   }

}