import java.util.LinkedList;
import java.io.*;

public class Assign {
    static String calmonths[] ={"Jan", "Feb", "Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    public static class Node{
        int date;
        String task;
        Node next;
        Node(int date, String task){
            this.date= date;
            this.task = task;
        }
        Node(){
            this.next = null;
        }
    }
    public static void enque(Node[] months,int month, int date, String task){ 
        if((month==0||month==2||month==6||month==7||month==9||month==11) && date>31){
            System.out.println("Enter Valid Date");
            return;
        }else if((month==3||month==5||month==8||month==10)&& date>30){
            System.out.println("Enter Valid Date");
            return;
        }else if(month==1 && date>29){
            System.out.println("Enter Valid Date");
            return;
        }
        Node node = new Node(date,task);
        int m = month-1;
        if(months[m]==null){
            months[m]= node;
        }else{
            Node  temp = months[m];
            Node prev = null;
            while(temp!=null){
                if(temp.date==date){
                    temp.task=temp.task+"?"+task;
                    break;
                }
                if( prev!=null && prev.date < date && temp.date > date){
                    prev.next=node;
                    node.next=temp;
                    break;
                }
                if(temp.next==null){
                    temp.next=node;
                    break;
                }
                prev=temp;
                temp= temp.next;
            }
        }
    }
    public static void deque(Node[] months, int month, int date){
        int m=month-1;
        for(int i=0; i<m;i++){
            months[i]=null;
        }
        Node temp = months[m];
        while(temp!=null && temp.date<date){
            temp =temp.next;
        }
        if(temp!=null){
            months[m]=temp;
        }
    }
    public static void display(Node[] months){
        for(int i=0; i<12;i++){
            if(months[i]!=null){
                System.out.print(calmonths[i]+"->");
                Node temp = months[i];
                while(temp!=null){
                    System.out.print(temp.date+"--"+temp.task+" || ");
                    temp=temp.next;
                }
                System.out.println();
            }
        }
        System.out.println(".......................................");
    }
    public static void main(String[] args) {
        Node[] months = new Node[12];
        for (int i = 0; i < 12; i++) {
            months[i]=null;
        }
        enque(months,1,2,"Hua");
        enque(months,1,2,"dusri baar");
        enque(months,3,18,"dusri 1 baar");
        enque(months,3,21,"dusri 2 baar");
        enque(months,3,19,"dusri 3 baar");
        enque(months,4,7,"dusri baar");
        enque(months,10,5,"dusri baar");
        enque(months,9,22,"dusri baar");
        display(months);
        deque(months,3,20);
        display(months);
        
    }    
}
