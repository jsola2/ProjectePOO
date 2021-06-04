<h1>Projecte POO UF4</h1>

<h3>Manual d’usuari</h3>

<p>Benvingut al sistema gestor empresarial BRJ©, per començar trobarem un menú d'opcions com aquest</p>

![image](https://user-images.githubusercontent.com/74617905/120678070-056c7880-c498-11eb-9317-4bc9c44653f7.png)

<p>Com veus a la imatge, pots fer multiples funcions, tenint en comte la opció que vols utilitzar, podràs afegir, esborrar i mostrar per pantalla amb multiples opcions</p>

<p>Ara farem una mostra de tots el usos de la aplicació</p>

<h4>Afegirem un nou producte, per tant seleccionem la opció 1: </h4>

![image](https://user-images.githubusercontent.com/74617905/120678947-efab8300-c498-11eb-88e8-991f0331f87e.png)

<p>Introduirem les dades que la aplicació et demana i premem enter, una vegada surt el missatge "Connexió de la base de dades establerta", significa que les dades 
s'estan introduïnt, en quan torni el menú principal, ja haura acabat el procés d'introducció de les teves dades.</p>

<h4>Ara la esborrarem de la base de dades, per tant premem la opció 2: </h4>

![image](https://user-images.githubusercontent.com/74617905/120679330-5892fb00-c499-11eb-831c-3829905770ea.png)

<p>Recorda que mentre la connexió de la base de dades és establerta, no pot apagar l'ordinador, podries fe mal tota la base de dades!</p>

<h4>Anem a mostrar els productes de la nostra base de dades, per tant premem l'opció 3: </h4>

![image](https://user-images.githubusercontent.com/74617905/120680216-58dfc600-c49a-11eb-8ac5-820a7ea90a3a.png)

<p>Com veuràs, surt un submenú, en el qual podem filtrar per moltes opcions. Fem una proba, anem a filtrar per el nom del producte, polsem l'opció 1: </p>

![image](https://user-images.githubusercontent.com/74617905/120759170-068ebb80-c513-11eb-9396-73ad542f9f69.png)

<p>Ja tenim la consulta feta, com hem introduït la opció 1 i hem possat el nom del producte, ens han sortit tots els registres amb el mateix nom.</p>

<p>Per filtrar per preu, polsarem l'opció 2 del submenú: </p>

![image](https://user-images.githubusercontent.com/74617905/120759734-9b91b480-c513-11eb-8dc9-d1837b41aa6e.png)

<p>Per filtrar per codi polsarem 3 del submenú: </p>

![image](https://user-images.githubusercontent.com/74617905/120761283-5078a100-c515-11eb-8222-8df254ccb01b.png)

<p>Si volem filtrar per marca polsarem la opció 4: </p>

![image](https://user-images.githubusercontent.com/74617905/120761492-89b11100-c515-11eb-8eb1-2ef2657c0661.png)

<p>Amb la opció 5, farem una recerca per descripció: </p>

![image](https://user-images.githubusercontent.com/74617905/120762145-430fe680-c516-11eb-8496-cc021996b5bf.png)

<p>Per acabar, si no volem filtrar i volem veure tot el que tenim a la base de dades, polsarem la opció 6: </p>

![image](https://user-images.githubusercontent.com/74617905/120762899-009ad980-c517-11eb-949b-ca73f85aeb1b.png)

<p>Ara que ja sabem com funcionen totes les opcions i tenim que sortir, per això polsem la opció 0 i sortirem del submenú, una vegada al menú principal tornem a polsar 0 i sortirem del gestor.</p>

![image](https://user-images.githubusercontent.com/74617905/120763078-29bb6a00-c517-11eb-8c64-fbc6e14964b8.png)

<h4>Ara aprendrem a afegir, esborrar i mostrar Clients de la nostra base de dades.</h4>
<p>Per afegir un nou client, polsarem la opció 4 i ens demanarà les dades del client, una vegada introduïm les seves dades, polsem enter i a contunació ja tindrem el nostre client pujat a la base de dades: </p>

![image](https://user-images.githubusercontent.com/74617905/120764787-cfbba400-c518-11eb-8893-866aab2d1a68.png)

<p>Ara esborrarem un client, polsarem la opció 5:</p>

![image](https://user-images.githubusercontent.com/74617905/120767717-bbc57180-c51b-11eb-9368-c69d433bd95c.png)


<p>Per cercar un client filtrat per nom i DNI, polsarem la opció 6 i seguidament polsarem 1 en el submenú: </p>

![image](https://user-images.githubusercontent.com/74617905/120769438-6ab67d00-c51d-11eb-8814-9dfee1b6aa94.png)

![image](https://user-images.githubusercontent.com/74617905/120769503-7ace5c80-c51d-11eb-89ed-e2f9979ab541.png)

<p>Filtrarem per clients Vip polsem 2 al submenú: </p>

![image](https://user-images.githubusercontent.com/74617905/120769614-99345800-c51d-11eb-9055-06432aca3f82.png)

<p>I si no volem filtrar per res, polsarem la opció 3 al submenú: </p>

![image](https://user-images.githubusercontent.com/74617905/120769894-dd275d00-c51d-11eb-9edc-676956a873ba.png)

<h4>I per finalitzar, anirem a la part d'afegir, esborrar i mostrar els nostres Empleats.</h4>
<p>A la opció 7 del menú principal, tenim la part d'afegir un treballador: </p>
<p></p>
<p></p>
<p></p>
<p></p>
<h3>Video</h3>

<p></p>

<h3>POO</h3>

<p>La classe Persona dona l'herencia amb les classes Client i Treballador, heretant els atributs nom, cognom, dni, poblacio i adreca. Després, a la classe Client tenim encapsulat l'atribut clientVip que es un boolean per identificar que un client es Vip o no. La classe Producte en té encapsulats tots els atributs per que no sutilitzen en més classes, tenim nom, preu, codi, marca i descripció. La classe Treballasor té encapsulat el tipus de categoria dels empleats, sent aquest un enum, que recull les 3 categories dels treballadors.</p>

<h3>VCS</h3>

<p>Hem seguit un ordre a on primer hem repartit les feines de les diferents classes que hem volgut crear per fer el programa, la creació de la base de dades, el diagrama de classes i l'estructura del codi font. La base de dades ha sigut creada per en Bangal, creant-la a AWS i utilitzant Mysql com a sistema gestor, el diagrama de classes l'ha fet en Ruben, utilitzant l'aplicació StratUML fent totes les classes i relacions que tenen que anar al projecte, l'estructura del codi a estat feta per en Jaime, primer creant un repositori a GitHub i després crear l'estructura a la aplicació IntelliJ Idea, creant les classes i fent el menú principal. </p>

<p>La classe "ConectarBaseDades" a estat creada per en Bangal, a on està el codi de connexió amb la base de dades, també s'ha encarregat de la classe "Client", creant els seus constructors, funcions i metodes, creats a la classe GestorDades. La classe Producte la creat en Ruben amb tot el que inclou, ha creat dins de la classe Interficie els missatges de menú principal i submenús. Per últim, en Jaime a creat la classe Treballador creant una classe enum anomenada TipusDempleatper repartir amb tots els treballadors les seves categories dintre de la gestió de l'empresa, totes les classes tenen de cin a set atributs, amb herencia anomenada Persona que importa gran dels atributs de Client i Treballador.</p>

<p>Hem tingut diversos problemes amb el moviment entre branques, ja que es la primera vegada que l'implementem a un projecte, l'hem estat solucionan recolsant-nos entre els 3, pregunatant al principi, avanç de fer un push o un pull. També, hem tingut algún problema amb la base de dades i la simple implementació del codi, sent solucionat amb el recolse de l'equip.</p>
