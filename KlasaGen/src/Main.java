class MyArrayList<E>{
    int size;
    Object[] tablica;

    public MyArrayList(){
        size=0;
        tablica = new Object[1];
    }

    public void add (E e){
        if(size==0){
            tablica[0] = e;
            size++;
        }
        else if(size==tablica.length){
            powieksztab();
            tablica[size]= e;
            size++;
        }
        else {
            tablica[size]= e;
            size++;
        }

    }

    public void add(int index, E e){
        Object[] temp;
        if(size== tablica.length)
        {
            powieksztab();
            temp = new Object[tablica.length];
        }
        else
        {
            temp = new Object[tablica.length];
        }
        for(int i=0; i<index;i++){
            temp[i]=tablica[i];
        }
        temp[index]=e;
        for(int i = index;i<size;i++){
            temp[i+1]=tablica[i];
        }
        tablica= temp;
    }

    public E remove (int index){
        Object e=null;
        if(index>=0 && index< tablica.length)
        {
            Object[] temp = new Object[tablica.length];
            for(int i=0; i<index;i++){
                temp[i]=tablica[i];
            }
            e=tablica[index];
            for(int i = index;i<size;i++){
                temp[i]=tablica[i+1];
            }
            tablica= temp;
            size--;
        }
        double stosunek = (double)(size)/ (double)(tablica.length);
        if(stosunek < 0.25)
        {
            System.out.println(stosunek);
            pomniejsztab();
        }
        return (E) e;
    }

    public E get (int index){
        return (E) tablica[index];
    }


    public void powieksztab(){
        int wielkosc_nowej = (int) (tablica.length + tablica.length*1.5);
        Object[] t = new Object[wielkosc_nowej];
        for(int i=0; i< size;i++){
            t[i]=tablica[i];
        }
        tablica = t;
    }

    public void pomniejsztab(){
        int wielkosc_nowej = (int) (tablica.length - tablica.length*0.5);
        Object[] t = new Object[wielkosc_nowej];
        for(int i=0; i< size;i++){
            t[i]=tablica[i];
        }
        tablica = t;
    }

    public void wyswietlroboczo(){
        for (Object ob:tablica){
            System.out.print(ob+" ");
        }
        System.out.println();
    }

    public void wyswietl(){
        for (Object ob:tablica){
            if (ob!=null){
                System.out.print(ob+" ");
            }
        }
        System.out.println();
    }

}

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.wyswietlroboczo();
        myArrayList.wyswietl();
        myArrayList.add(2,7);
        myArrayList.wyswietlroboczo();
        myArrayList.wyswietl();
        myArrayList.remove(0);
        myArrayList.wyswietlroboczo();
        myArrayList.wyswietl();
        System.out.println(myArrayList.get(0));


        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.wyswietlroboczo();
        myArrayList.wyswietl();
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.remove(0);
        myArrayList.wyswietlroboczo();
        myArrayList.wyswietl();

    }
}
