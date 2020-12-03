package paging;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class driver{

    public static int frames; //Number of frames in memory
    public static int[] pages; //Page numbers requested by the cpu
    public static List<Round> roundList = new ArrayList<>();
    public static void main(String args[]) throws FileNotFoundException {
        getInput(getFile());  //get the input and set varibles
        runRound();

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

    public static void runRound(){
        for(int i = 0; i<roundList.size(); i++){
            int fifoFaults = Fifo.swap(roundList.get(i));
            int lruFaults = lru.swap(roundList.get(i));
            int lfuFaults = lfu.swap(roundList.get(i));
            
        }
    }

    /*
    This method take the input from the input file and will tranfer it to classes to be used in the rest of the 
    program
    */
    public static void getInput(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        int i = 0;
        boolean done = false;
        while(in.hasNextInt()){
            roundList.add(new Round());
            roundList.get(i).frames = in.nextInt();
            while(!done){
                int num = in.nextInt();
                if (num == -1){
                    done = true;
                }
                else{
                    roundList.get(i).pages.add(num);
                }
            }
            done = false;
            i++;
        }
        in.close();
    }

    /*
    This method will get the file path of the input file
    */
    public static File getFile(){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Please enter the path of input file.");
        String filePath = stdIn.nextLine();
        File input = new File(filePath);
        stdIn.close();
        return input;
    }



}
