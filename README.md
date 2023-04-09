# Santa-Claus-Project
#Copyright Andreea-Cristina Stan 323CA

-Pentru a pastra o continuitate proiectului, am ales sa pastrez explicatiile pentru etapa 1 si sa adaug noi informatii
despre ce adaugiri am facut sau despre noile clase create/design pattern-uri folosite.

Intregul proiect incepe prin crearea propriei baze de date ce contine toate informatiile necesare pentru efectuarea rundelor.
Pentru a face acest lucru, m-am folosit de object mapper pentru a citi din fisierele JSON trimise ca input.

Pentru parsarea acestora in mod corect, am creat clase separate (Toate aceste clase se afla in pachetul init) ce contin,
din aproape in aproape, variabile ce construiesc baza de date (spre exemplu, clasa de baza se numeste InputLoader ce contine,
pentru lista de modificari anuale, o entitate numita annualChanges - reprezentata printr-un arrayList).
*In cea de-a doua etapa am adaugat noile campuri necesare in clasele potrivite(spre exemplu, in clasa ChildrenInit am adaugat
stringul elf care retine tipul elfului asignat fiecarui copil).

Dupa crearea bazei de date cu tot ce este necesar, incepe efectuarea propriu zisa a rundelor. Parcurg cu un for toti cei
numberOfYears ani, apoi stabilesc a cata runda este.
Daca este prima runda, apelez direct metoda care calculeaza toate valorile necesare pentru distribuirea de cadouri(exemplu:
budgetUnit), daca nu este prima runda, apelez mai intai metodele ce efectueaza modificarile anuale, urmand ca mai apoi sa
efectuez calculele efectuate si la prima runda.
Dupa efectuarea tuturor rundelor dintr-un test, am grija sa adaug toate rezultatele in fisierul json de output.
Acest lucru se efectueaza in mai multe etape:
    1. Initial am grija ca dupa fiecare runda dintr-o simulare, sa adaug listelor finale de output informatiile corespunztoare.
    (pentru a crea instanta ce contine toate informatiile necesare la output despre copii m-am folosit de design pattern-ul
    builder)
    2. Apoi, cand am efectuat toate rundele, iar array-ul final(annualChildren) este complet, adaug toate informatiile in
    fisierul json folosindu-ma de ObjectMapper si PrettyPrinter pentru a distribui pe cate un rand toate informatiile.

Pentru o structurare cat mai concisa si pentru a fi cat mai usor de vizualizat intreaga rezolvare a temei, am ales sa-mi impart
operatiile in pachete cat mai bine sortate:

In pachetul init se afla toate clasele ce ajuta la crearea bazei de date, fiecare astfel de clasa cu informatii are numele
*Init(exemplu : ChildrenInit) si stocheaza ce este sugestiv pentru ea (exemplu, in clasa ChildrenInit am id-ul, numele,
prenumele si alte informatii relevante stocate din fisierele json pentru copil). Baza de date principala este numita
InputLoader, si de aici se ramifica fiecare clasa in functie de nevoie.

In pachetul rounds am inclus clasa ce se ocupa cu efectuarea fiecarei runde dupa ce modificarile pe baza de date sunt
efectuate(daca este cazul). Astfel, clasa FirstRound, parcurge intreaga lista de copii a mosului si extrage toate valorile
necesare pentru calcularea AverageScore-ului si BudgetUnit-ului si le afla fie folosind metode specifice, fie direct
dupa formulele oferite. Dupa ce toate acestea sunt aflate, se apeleaza fie direct metoda de asignare a cadourilor daca
este vorba despre runda initiala, fie se apeleaza metodele specifice de sortare in functie de strategia primita in input
initial, iar apoi metoda de atribuire. In final, se apeleaza metoda ce "seteaza" cadourile asa cum trebuie, intrucat am
ales sa creez o lista noua ce contine copiii sortati pe care o folosesc la atribuirea de cadouri. Nu in ultimul rand, ma
asigur ca si copiii ce au atribuit elful galben primesc cadou asa cum trebuie.

In pachetul averagescorestrategy este inclusa toata logica pentru calcularea AverageScore-ului fiecarui copil.
Pentru ca este nevoie de o strategie de calculare cu mai multe implementari posibile, in cadrul simularii, am ales sa ma
folosesc de design pattern-ul Strategy. Pentru implemenarea lui m-am folosit si de design pattern-ul Factory care, pentru
a economisi memorie a fost suficient să am o singură instanță a factory-ului și să o folosesc pe aceasta. Astfel, am ales sa
ma folosesc si de design pattern-ul singleton pentru a crea o singura instanta a Fcatory-ului si sa o folosesc doar pe ea
in cadrul proiectului.
Interfata AverageScoreStrategy reprezinta coneziunea dintre factory si metodele de rezolvare a averageScore-ului, iar
cele trei clase ce implementeaza aceasta interfata contin metodele de calculare a score-ului (pentru baby se returneaza
automat score-ul 10, pentru kid se realizeaza o medie aritmetica, iar pentru teen o medie ponderata).

In pachetul receivedgifts am ales sa includ clasele ce se ocupa de tot ce inseamna distribuirea de cadouri copiilor.
Acest lucru se efectueaza in 2 etape:
    1. se afla bugetul asignat de catre mos Craciun fiecarui copil in parte, apoi se parcurge lista copilului de preferinte
    legata de cadourile pe care le vrea. (in clasa GiftCategory)
    2.Se verifica daca acel cadou este cel mai potrivit pentru el sau nu (spre exemplu, daca acestuia ii este asignat un
    cadou, ma asigur ca este si cel mai ieftin din categoria din care face parte; am grija ca de fiecare data cand un copil
    primeste un cadou bugetul alocat initial pentru acesta sa se actualizeze treptat pentru a nu exista riscul de a primi
    mai multe cadouri decat ar trebui) - toata logica pentru aceasta etapa se realizeaza in clasa GiftAssign.

In pachetul annualchanges am ales sa includ intreaga logica pentru modificarile ce au loc in fiecare an in baza de date.
Astfel, in clasa generala Changes ma folosesc de design pattern-ul Command pentru cresterea varstei fiecarui copil si pentru
a actualiza bugetul anual al mosului, iar apoi, in functie de ce schimbari au loc pentru anul curent, sa actualizez lista
de cadouri, lista de copii sau unele informatii pentru copii.
Daca era nevoie sa efectuez modificari pentru anumiti copii, am ales sa fac acest lucru intr-o clasa separata (ChildrenChanges)
stabilind ce fel de modificare se va efectua.

In pachetul assignsortstrategy este cuprinsa toata logica pentru sortarea, in functie de strategia primita la input in annual
changes, a listei de copii.
Folosindu-ma de design pattern-urile factory si strategy, dupa ce stabilesc ce tip de sortare va avea loc, apeleze metoda
corespunzatoare. Pentru sortare am ales sa ma folosesc de un HashMap in care sa memorez cele doua criterii dupa care se
va sorta lista de copii(spre exemplu, daca sortez in functie de average score-ul fiecarui oras am ales sa memorez in
cheie numele orasului, iar in valoare media aritmetica a averageScore-urilor copiilor din orasul respectiv) apoi sa memorez
rezultatul intr-o lista.

In pachetul jsonwriter am ales sa includ intreaga logica pentru scrierea in fisierele de output json.
Pe langa clasele care ajuta la formarea outputului dorit(AnnualChildren, Children), am inclus si clase cu alte intrebuintari:
    -In clasa Output am ales sa ma folosesc de design pattern-ul Builder prin intermediul caruia sa salvez toate
    informatiile despre copii necesare in fisierele json de iesire.
    -In clasa Creator realizez efectiv acest lucru prin crearea unei noi instante a clasei output cu ajutorul Builder-ului,
    pentru care apelez constructorul mentioat anterior.
    -In clasa WriterHelp am ales sa ma folosesc de design pattern-ul singleton pentru a crea o singura instanta pentru
    clasa ce se ocupa cu memorarea intr-un arrayList a tuturor informatiilor necesare pentru scriere (de exemplu, daca runda nu
    este cea initiala, este necesar sa creez o noua instanta children in care sa adaug copiii de la acea runda pe rand, la
    final adaugand doar la array-ul final toate valorile obtinute.

    Intreaga tema se foloseste de gettere si settere pentru a actualiza sau accesa informatia atunci cand este nevoie.
