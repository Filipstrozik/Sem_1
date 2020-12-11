public class GrupaStud implements ListaDanych{
        String info; //przechowuje informacje o zestawienu
        Student [] students;//wykaz studentow
        public GrupaStud(String i, Student [] ts){
                info = i;
                students = ts;
        }
        public void DodajStudenta(Student s){
                Student []temp = new Student[students.length+1];
                for(int i=0;i<students.length;i++){
                        temp[i]=students[i];
                }
                temp[students.length]=s;
                students=temp;
        }

        public double srednia(){ //potrzebna by obliczyc dodatkowa informacje
                double temp=0;
                for(int i=0;i<students.length;i++){
                        temp=temp+students[i].ocena;
                }
                return (temp/students.length);
        }

        @Override
        public String lista() {
                String s = info+"\n";
                s=s+String.format("%2s %10s  %10s  %10s %10s \n","L.p" ,"imie", "nazwisko",
                        "nr_indeksu", "ocena");
                for(int i=0;i<students.length;i++){
                        s=s+String.format("%2d %10s  %10s  %10d %10.2f \n",i+1 , students[i].imie, students[i].nazwisko,
                                students[i].nr_indeksu, students[i].ocena);
                } //oczywisicie, gdyby zmienne obiektu student bylyby private to trzebabylo uzyc np.getimie()
                s=s+String.format("Srednia studentow : %5.2f",srednia()); //dodatkowa infromacja
                return s;
        }
}
