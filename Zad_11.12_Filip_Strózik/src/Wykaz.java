public class Wykaz {

        ListaDanych lista;

        public Wykaz(ListaDanych l){
            lista = l;
        }

        public String toString(){
            String s="";
            s=s+lista.infozestawienia();
            s=s+lista.naglowek_listy();
            String [] temp = lista.lista();
            for(int i=0;i< temp.length;i++){
                s=s+String.format("%2d  %s",i+1,temp[i]);
            }
            s=s+lista.dodatkowe_info();
            return s;
        }

}
