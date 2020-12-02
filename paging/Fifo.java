package paging;
import java.util.LinkedList;
import java.util.Queue;

public class Fifo {

    public static Queue<Integer> q = new LinkedList<>();


    public static int swap(Round round){ 
        int faults = 0;
        for(int i = 0; i< round.pages.size(); i++){
            if (q.contains(round.pages.get(i))){
                System.out.println("No fault"); //debug
            }
            else{
                if(q.size() < 3){ //check for open frames to save page in 
                    q.add(round.pages.get(i)); // if a page fault occurs load page into open frame
                }
                else{
                    q.remove();//remove first in page
                    q.add(round.pages.get(i));
                }
                faults++;
            }

        }
        System.out.println(faults);
        return faults;
    }
    
}
