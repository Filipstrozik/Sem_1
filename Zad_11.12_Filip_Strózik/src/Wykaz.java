public class Wykaz {
        ListaDanych lista;

        public Wykaz(ListaDanych l){
            lista = l;
        }

        public String toString(){
            return lista.lista();
        }

}
