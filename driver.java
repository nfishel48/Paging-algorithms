import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class driver{

    public static int frames; //Number of frames in memory
    public static int[] pages; //Page numbers requested by the cpu
    public static List<Round> roundList = new ArrayList<>();
    public static void main(String args[]) throws FileNotFoundException {
        getInput(getFile());  //get the input and set varibles
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

    public static void getInput(File input) throws FileNotFoundException {
        Scanner in = new Scanner(input);
        int i = 0;
        while(in.hasNextLine()){
            roundList.add(new Round(
                
            ));
        }

    }

    public static File getFile(){
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Please enter the path of input file.");
        String filePath = stdIn.nextLine();
        File input = new File(filePath);
        return input;
    }



}
