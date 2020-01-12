SIMIONESCU ANA-MARIA
323CA

				ETAPA 1
CITIRE
	Urmărind modelul primei teme, am implementat clasele GameInput și
GameInputLoader care lucrează cu FileIO si returneaza inputul în formatul
necesar prelucrării ulterioare.

HARTA
	Am implementat harta ca un singleton pentru a obtine o singură 
instanță a acesteia.
	Fiecare locație a hărții este o instanță a clasei Terrain. Aceasta
este extinsă în cele 4 tipuri de teren. Am implementat clasa TerrainFactory
care apelează constructorul clasei corespunzătoare fiecărui tip de teren.
TerrainFactory este de asemenea un singleton.
	Clasa Map conține o matrice de instanțe ale clasei Terrain și o
matrice ale cărei elemente reprezintă o listă de maxim 2 jucatori (jucatorii
care se află la un moment dat in acea căsuță).

JUCĂTORI
	Clasa de bază pe care o moștenesc cele 4 tipuri de jucători este Hero.
Aceasta conține câmpurile comune tuturor jucătorilor precum coordonatele în
care se află, level, xp, hp. În aceasta obțin unica instanță a hărții pentru
a putea implementa metoda de Move a jucatorilor pe hartă si pentru a-i așeza
pe harta odată cu apelarea constructorului.
	HeroFactory este singletonul care se ocupă de apelarea constructorului
potrivit fiecărui tip de jucător.

DOUBLE DISPATCH
	Am implementat Double Dispatch în clasa Hero. Fiecare tip de jucător
are o implementare diferită a funcției attack, variind după tipul de jucător
pe care îl atacă. Funcțiile sunt declarate abstract în clasa Hero. Fiecare 
clasă copil implementează de asemenea metoda isAttackedBy.


				ETAPA 2

ÎNGERI
	Am implementat îngerii în același fel ca eroii, utilizând un factory
și o clasă de bază pe care o moștenește fiecare tip de înger. Am realizat
un nou double dispatch pentru interacțiunea dintre îngeri și jucători.
Fiecare tip de înger are o implementare diferită a funcției affect, variind
după tipul de jucător pe care acționează. Funcțiile sunt declarate abstract
în clasa Angel. Fiecare clasă Hero implementează de asemenea metoda isAffectedBy.

MARELE VRĂJITOR
	Este implementat ca un nou caracter, care cuprinde în membrii săi toți
observatorii. Aceștia fac parte din package-ul observers și implementează
funcția update, cu tipul de output corespunzător. Marele Vrajitor folosește
pattern-ul singleton.

STRATEGII
	Strategiile folosesc de asemenea un factory si implementează o interfață
astfel încât la run-time se decide tipul de strategie utilizat de fiecare jucător.

HARTA
	Utilizare hărții s-a modificat pentru această etapă în sensul că acum
jucătorii morți nu mai sunt scoși de pe hartă în cazul în care un înger îi va
invia. Deci lista jucătorilor dintr-o căsuță poate fi mai mare și în momentul
luptei îi voi căuta în acea listă pe cei vii.



