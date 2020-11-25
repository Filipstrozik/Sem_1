class Tab {
    int t[][];
    Tab(int [] schemat_tablicy){
        t=new int[schemat_tablicy.length][];
        for(int i=0;i<t.length;i++)
        {
            int [] temp = new int[schemat_tablicy[i]];
            t[i]=temp;
        }
    }

    public void wypelnijLosowo(int a, int b){
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                t[i][j]=(int)(Math.random()*(b-a) + a);
            }
        }
    }

    public int[] znajdzMax(){
        int[] wynik= new int[2];
        int max=0;
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                if(t[i][j]>max)
                {
                    max=t[i][j];
                    wynik[0]=i;
                    wynik[1]=j;
                }
            }
        }
        return wynik;
    }

    public void usunWiKmax(){
        int [] tw = znajdzMax();
        System.out.println("\t"+t[tw[0]][tw[1]]+"\n");
        usunWiersz(tw[0]);
        usunKolumne(tw[1]);
    }

    public String toString(){
        StringBuilder s=new StringBuilder();
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                s.append(t[i][j]+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

    public void usunWiersz(int w){
        int[][] temp = new int[t.length-1][];
        if(w==0){//kopiuj ponizej
            for(int i=1;i<t.length;i++){
                int[] temp2 = new int[t[i].length];
                for(int j=0;j<t[i].length;j++){
                    temp2[j]=t[i][j];
                }
                temp[i-1]=temp2;
            }
        }
        else if(w<t.length-1)//kopiju z przerwa
        {
            for(int i=0;i<w;i++){
                int[] temp2 = new int[t[i].length];
                for(int j=0;j<t[i].length;j++){
                    temp2[j]=t[i][j];
                }
                temp[i]=temp2;
            }
            for(int i=w+1;i<t.length;i++){
                int[] temp2 = new int[t[i].length];
                for(int j=0;j<t[i].length;j++){
                    temp2[j]=t[i][j];
                }
                temp[i-1]=temp2;
            }
        }
        else if(w==t.length-1)//kopiuj bez osataniego
        {
            for(int i=0;i<w;i++){
                int[] temp2 = new int[t[i].length];
                for(int j=0;j<t[i].length;j++){
                    temp2[j]=t[i][j];
                }
                temp[i]=temp2;
            }
        }
        t=temp;
    }

    public void usunKolumne(int k){
        int[][] temp = new int[t.length][];
        for(int i=0;i<t.length;i++){
            int[] temp2 = new int[t[i].length-1];
            if(k==0) {//kopiuj ponizej
                for(int j=1;j<t[i].length;j++){
                    temp2[j-1]=t[i][j];
                }
                temp[i]=temp2;
            }
            else if(k<t[i].length-1)//kopiju z przerwa
            {
                for(int j=0;j<k;j++){
                    temp2[j]=t[i][j];
                }
                for(int j=k+1;j<t[i].length;j++){
                    temp2[j-1]=t[i][j];
                }
                temp[i]=temp2;

            }
            else if(k==t[i].length-1)
            {
                for(int j=0;j<k;j++){
                    temp2[j]=t[i][j];
                }
                temp[i]=temp2;
            }
            else {
                temp2=t[i];
                temp[i]=temp2;
            }
        }
        t=temp;
    }

    public void wyswietl(){
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                System.out.printf("%5d",t[i][j]); //przy regualrneh 5x4 lub bedzie zawsze prostokat
            }
            System.out.println();
        }
    }
}




public class Main {

    public static void main(String[] args) {
        int [] schemat = {2,4,3,4};
	    Tab tablica = new Tab(schemat);
	    tablica.wypelnijLosowo(2,8);
	    tablica.wyswietl();
	    System.out.println();
	    tablica.usunWiKmax();
        tablica.wyswietl();
    }
}
