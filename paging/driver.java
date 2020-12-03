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
    }

    public static void runRound(){
        for(int i = 0; i<roundList.size(); i++){
            int fifoFaults = Fifo.swap(roundList.get(i));
            int lruFaults = lru.swap(roundList.get(i));
            int lfuFaults = lfu.swap(roundList.get(i));
            int opFaults = Optimal.swap(roundList.get(i));
            
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
