class driver{

    public int frames; //Number of frames in memory
    public int[] pages; //Page numbers requested by the cpu
    public static void main(String args[]){

        //get the input and set varibles

        //loop 4 times to run all algorithms

        //Display the results

    }

    /*
    This method will be triggerd when the virtual CPU tries to access a page that is not currently in main memory
    */
    public static void memFault(){

        //1. Put current process into blocking state

        //2. Find the page in the logical address space

        //3. Call page replacement algorithm

        //4. If page table is updated unblock the thread

        //5. Return to main.

    }



}
