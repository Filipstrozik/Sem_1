class Punkt {
    private double x;
    private double y;
    public Punkt(){
        x= Math.random()*10;
        y= Math.random()*10;
    }
    public Punkt(double x, double y){
        this.x= x;
        this.y= y;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public String toString()
    {
        return (x+" "+y);
    }
}
class ZbiorPkt{
    private Punkt [] zp;
    public ZbiorPkt(int n){
        zp = new Punkt[n];
        for(int i=0;i<n;i++)
        {
            zp[i]=new Punkt();
        }
    }
    Punkt [] getZp(){
        return zp;
    }

    public ZbiorPkt punktyWpodzbiorzeKol(ZbiorKol podzbiorkol)
    {
        Punkt [] temp= new Punkt[zp.length];
        int c=0;
        for(int p=0;p<zp.length;p++){
            boolean f =false;
            for(int k=0;k<podzbiorkol.zk.length;k++)
            {
                if(podzbiorkol.zk[k].CzyKoloMa(zp[p]))
                {
                    f=true;
                }
                else
                {
                    f=false;
                    break; //jeżeli do wszystkoch rownoczesnie czyli iloczyn roznicy z z tego zbioru, wychodzi na to
                }           // że jeżeli punkt nie nalezy co najwyzej do jednego kola to nie jest zaliczony.
            }
            if(f)
            {
                temp[c]=zp[p];
                c++;
            }
        }
        ZbiorPkt podzbiorpkt = new ZbiorPkt(c);
        for(int i=0;i< podzbiorpkt.zp.length;i++)
        {
            podzbiorpkt.zp[i]=temp[i];
        }
        temp=null;
        return podzbiorpkt;
    }

    public void wyswietl(){
        for(int i=0;i< zp.length;i++)
        {
            System.out.println("Punkt "+i+" "+zp[i]);
        }
    }
}


class Kolo{
    private Punkt sr; //srodek
    private double r; //promine
    public Kolo(Punkt srodek)
    {
        this.sr=srodek;
        this.r = Math.random()*2+1;
    }

    boolean CzyKoloMa(Punkt p){
        double dl = Math.sqrt(Math.pow(p.getX()-sr.getX(), 2)+Math.pow(p.getY()-sr.getY(), 2));
        if(dl<=r && dl>0)  // tutuaj dl>0 jezeli punkt ktory jest srodkiem kola sie zalicza lub tez nie
            return true;   // jezeli tak to bez && dl>0
        else
            return false;
    }
    public String toString()
    {
        return ("Kolo "+sr+" "+r);
    }
}

class ZbiorKol {
    Kolo [] zk;
    public ZbiorKol(ZbiorPkt zbiorPkt)
    {
        zk=new Kolo[zbiorPkt.getZp().length];
        for(int i=0;i< zk.length;i++)
        {
            zk[i]=new Kolo(zbiorPkt.getZp()[i]);
        }
    }
    private ZbiorKol(int dl)
    {
        zk=new Kolo[dl];
    }

    public ZbiorKol posiadajacychpkt(Punkt p)
    {

        int c=0;
        Kolo [] temp = new Kolo[zk.length];
        for(int i=0; i<zk.length;i++)
        {   if(zk[i].CzyKoloMa(p))
            {
                temp[c] = zk[i];
                c++;
            }
        }
        ZbiorKol podzbior = new ZbiorKol(c);
        if(c==0)
            System.out.println("Nie ma takich kol");
        for(int i=0; i<podzbior.zk.length;i++)
        {
            podzbior.zk[i]=temp[i];
        }
        temp=null;
        return podzbior;
    }
    public void wyswietl(){
        for(int i=0;i< zk.length;i++)
        {
            System.out.println(i+" "+zk[i]);
        }
    }
}



public class Main {

    public static void main(String[] args) {
        int n=10;
        ZbiorPkt zbior_punktow = new ZbiorPkt(10);
        System.out.println("zbior_punktow:");
        zbior_punktow.wyswietl();
        ZbiorKol z = new ZbiorKol(zbior_punktow);
        System.out.println("zbior Kol:");
        z.wyswietl();
        ZbiorKol podz = z.posiadajacychpkt(new Punkt(5.0,5.0));
        System.out.println("podzbior Kol spelniajacych podpunkt b:");
        podz.wyswietl();
        ZbiorPkt podzpkt = zbior_punktow.punktyWpodzbiorzeKol(podz);
        System.out.println("podzbior punktow spelniajacych podpunkt c:");
        podzpkt.wyswietl();

    }
}
