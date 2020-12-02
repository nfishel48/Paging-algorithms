package paging;
import java.util.*;


public class Fifo {

    public static Queue<Integer> q = new LinkedList<>();
    public static List<PrintBuffer> faultList = new ArrayList<>();

    public static int swap(Round round){ 
        int faults = 0;
        for(int i = 0; i< round.pages.size(); i++){
            faultList.add(new PrintBuffer());
            faultList.get(i).requestPage = round.pages.get(i);
            faultList.get(i).frames = round.frames;
            if (q.contains(round.pages.get(i))){
                //System.out.println("No fault"); //debug
            }
            else{
                if(q.size() < 3){ //check for open frames to save page in 
                    q.add(round.pages.get(i)); // if a page fault occurs load page into open frame
                    faultList.get(i).refString = makeRefString();//PROBLEM HERE only added this one page when we need the hole queue
                }
                else{
                    q.remove();//remove first in page
                    q.add(round.pages.get(i));
                    faultList.get(i).refString = makeRefString();
                }
                faults++;
            }
        }
        System.out.println(faults);
        printTable(round);
        return faults;
    }

    public static String makeRefString(){
        //Queue<Integer> copy = q.clone();
        Queue<Integer> copy = new LinkedList<>(q);
        String ref = "";
        for(int i = 0; i<copy.size(); i++){
            String num = Integer.toString(copy.remove());
            ref = ref+" "+num;
        }
        return ref;
    }



    public static void printTable(Round round){
        // faultList.get(i).pages.get(i).remove() gets number from printbuffer queue
        System.out.println("FIFO:");
        int size =  round.pages.size();
        for(int i = 0; i<size; i++){
            System.out.println(Integer.toString(faultList.get(i).requestPage));
            System.out.println(faultList.get(i).refString);
        }
       

    }
    
}
