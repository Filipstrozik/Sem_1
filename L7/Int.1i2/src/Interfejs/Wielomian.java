package Interfejs;

public class Wielomian implements Funkcja{
    private double [] wsp;
    private int n;
    public Wielomian(double...w){
        wsp=w;
        n=wsp.length-1;
    }

    @Override
    public double f(double x) {
        double w = wsp[0];
        for(int i=1;i<n+1;i++){
            w = w*x+wsp[i];
        }
        return w;
    }

    @Override
    public String wzor() {
        String s = "F(x)=";
        for(int i=0;i< wsp.length;i++){
            if(i==0)//pierwszy
            {
                if(Math.abs(wsp[i])==1.0){
                    if(wsp[i]>0)//pierwszy i dodadtni
                    {
                        s=s+"x^"+(n-i);
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-x^"+(n-i);
                    }
                }
                else
                {
                    if(wsp[i]>0)//pierwszy i dodadtni
                    {
                        s=s+wsp[i]+"x^"+(n-i);
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-"+Math.abs(wsp[i])+"x^"+(n-i);
                    }
                }
            }
            else if(i==n-1)//x^1
            {
                if(Math.abs(wsp[i])==1.0){
                    if(wsp[i]>0)
                    {
                        s=s+"+x";
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-x";
                    }
                }
                else
                {
                    if(wsp[i]>0)
                    {
                        s=s+"+"+wsp[i]+"x";
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-"+Math.abs(wsp[i])+"x";
                    }
                }
            }
            else if(i==n)
            {
                if(wsp[i]>0)
                {
                    s=s+"+"+wsp[i];
                }
                else if(wsp[i]<0)
                {
                    s=s+"-"+Math.abs(wsp[i]);
                }
            }
            else {
                if(Math.abs(wsp[i])==1.0){
                    if(wsp[i]>0)
                    {
                        s=s+"+x^"+(n-i);
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-x^"+(n-i);
                    }
                }
                else {
                    if(wsp[i]>0)
                    {
                        s=s+"+"+wsp[i]+"x^"+(n-i);
                    }
                    else if(wsp[i]<0)
                    {
                        s=s+"-"+Math.abs(wsp[i])+"x^"+(n-i);
                    }
                }
            }

        }
        return s;
    }
}
