package Implementation;

import java.util.Scanner;

public class AbebeImplementationStart {

    public static void main(String[] args) {
        Integer[] A = new Integer[10];
        Scanner key = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the     " + (i + 1) + "    element?");
            A[i] = key.nextInt();
        }
        for (int c : AbebeArray.insertionSort(A)) {
            System.out.println("sorted by insertion     :element" + "    " + c);
        }
        for (int c : AbebeArray.bubbleSort(A)) {
            System.out.println("sorted by bubbleSort       :element" + "    " + c);
        }
        for (int c : AbebeArray.mergeSort(A)) {
            System.out.println("sorted by mergeSort               :element" + "    " + c);
        }
        for (int c : AbebeArray.quickSort(A)) {
            System.out.println("sorted by quickSort                     :element" + "    " + c);
        }
        AbebeArray.SortingTimeComlixity();
        AbebeArray.SortArray(A);
        AbebeArrayList<Integer> Alist = new AbebeArrayList<>(A);
        AbebeLinkedList<Integer> Blist = new AbebeLinkedList<>(A);
        AbebeQueue<Integer> Clist = new AbebeQueue<>();
        System.out.println("...........test/demonstrate all their functionality/methods in ABEBEARRAYLIST..........");
        //adding   10000 to test add()
        Alist.add(100000);
        //adding   10000  at 5 to test add()
        Alist.add(5, 10000);
        Integer[] W = new Integer[5];
        W[0] = 78;
        W[1] = 45;
        W[2] = 4796;
        W[3] = 52;
        W[4] = 26;
        //make a new list to test containsall()
        AbebeArrayList<Integer> Alist2 = new AbebeArrayList<>(W);
        //test if Alist contains Alist2
        System.out.println("testing the continasall method we get :  " + Alist.containsAll(Alist2));
        //test contains()
        System.out.println("testing the contains method we get :  " + Alist.contains(6));
        System.out.println("testing the equals method we get :  " + Alist.equals(Alist2));
        System.out.println("testing the get method we get :  " + Alist.get(3));
        Alist.OutPut();
        //testing remove
        //Alist.remove(10000);
        System.out.println("...........test/demonstrate all their functionality/methods in ABEBELINKEDLIST........");
        //testing the add methods
        System.out.print("elemtes in the AbebeLikedlist   ");
        Blist.OutPut();
        Blist.add(3, 88888);
        Blist.addFirst(11111);
        Blist.addLast(9999);
        System.out.print("testing the add methods in the FIRST,LAST AND 3 INDEXES we get :  ");
        Blist.OutPut();
        System.out.print("testing the remove methods in the FIRST,LAST AND 4 INDEXES we get :  ");
        Blist.remove(4);
        Blist.removeFirst();
        Blist.removeLast();
        Blist.OutPut();
        System.out.println("testing the getFirst method we get :  " + Blist.getFirst());
        System.out.println("testing the getLast method we get :  " + Blist.getLast());
        System.out.println("testing the contains method with valeu 56 we get :  " + Blist.contains(56));
        System.out.println("testing the get method we get :  " + Blist.get(3));
        System.out.print("testing the set in index 2 method we get :  " + Blist.set(2, 1000) + "    ");
        Blist.OutPut();
        System.out.println("testing the indexOf method we get :  " + Blist.indexOf(1000));
        System.out.println("testing the lastIndexOf method we get :  " + Blist.lastIndexOf(89));
        System.out.println("testing the size method we get :  " + Blist.size());
        System.out.println("...........test/demonstrate all their functionality/methods in QUEUES........");
        System.out.println("testing the enqueue method we get :  ");
        for (Integer a : A) {
            Clist.enqueue(a);
            Clist.OutPut();
        }
        System.out.println("testing the getSize method we get :  " + Clist.getSize());
        System.out.print("testing the dequeue method we get :  ");
        Clist.dequeue();
        Clist.OutPut();
    }
}
