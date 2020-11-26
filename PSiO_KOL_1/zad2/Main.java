//Strózik Filip
//260377
class Tab{



    public static int[][] metoda1 (int [][] t){
        int dl = znajdzmaxdlugos(t);
        int [][] temp = new int [t.length][dl];
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                temp[i][j]=t[i][j];
            }
            if(t[i].length<dl){
                for(int j=t.length;j<dl;j++){
                    temp[i][j]=-1;
                }
            }
        }
        return temp;
    }

    public static int[][] utworz(int [] schemat_tablicy){

        int [][]t=new int[schemat_tablicy.length][];
        for(int i=0;i<t.length;i++)
        {
            int [] temp = new int[schemat_tablicy[i]];
            t[i]=temp;
        }
        return t;
    }

    public static int [][] wypelnijLosowo(int [][]t){
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                t[i][j]=(int)(Math.random()*(10));
            }
        }
        return t;
    }


    public static int znajdzmaxdlugos(int [][] t){
        int max=0;
        for(int i=0;i<t.length;i++)
        {
            if(t[i].length>max){
                max=t[i].length;
            }
        }
        return max;
    }


    public static void wyswietl(int [][]t){
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[i].length;j++)
            {
                System.out.printf("%5d",t[i][j]);
            }
            System.out.println();
        }
    }

}



public class Main {

    public static void main(String[] args) {
        int [] schemat = {3,4,2};
	    int [][] temp = Tab.utworz(schemat);
        Tab.wyswietl(temp);
        System.out.println();
        int [][] temp2 = Tab.wypelnijLosowo(temp);
        Tab.wyswietl(temp2);
        System.out.println();
        int [][] temp3 = Tab.metoda1(temp2);
        Tab.wyswietl(temp3);

    }
}
