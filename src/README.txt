SIMIONESCU ANA-MARIA
323CA

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