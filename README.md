# ⚡️ Gestió d'Estacions de Recarrega de Vehicles Elèctrics ⚡️

---

## 📋 Descripció del projecte

Aquest projecte en **Java** gestiona una llista d’estacions de recarrega per a vehicles elèctrics.  
Permet llegir dades d’un fitxer CSV i oferir diverses funcionalitats com eliminar estacions d’una població, buscar la més propera a una ubicació, filtrar per tipus de velocitat de recarrega, i mostrar les estacions amb més capacitat o més properes.

---

## 🚀 Funcionalitats principals

- Lectura de dades des d’un fitxer CSV amb informació de fins a 418 estacions.  
- Menú interactiu per seleccionar diferents operacions:  
  - Eliminar estacions d’una població.  
  - Trobar la primera estació d’una província i comparar distàncies.  
  - Comptar estacions segons tipus de velocitat.  
  - Mostrar estació amb més places disponibles.  
  - Mostrar estacions més properes a una ubicació amb radi configurable.  
  - Visualitzar totes les estacions carregades.  
- Càlcul de distàncies geogràfiques per determinar proximitats.

---

## 🛠️ Funcionament i ús

1. En executar el programa, es demana a l’usuari indicar quantes línies del fitxer vol llegir (fins a 418).  
2. El programa llegeix les dades del fitxer `EstacionsRecarregaReduit.csv`.  
3. S’activa un menú amb diferents opcions per manipular i consultar les estacions.  
4. L’usuari tria una opció i el programa executa l’acció corresponent.  
5. El menú es repeteix fins que l’usuari decideix sortir.

---

## 💻 Com compilar i executar

Assegura’t de tenir Java JDK 8 o superior instal·lat.

1. Compila el projecte (executa la comanda des de la carpeta arrel on tens els fitxers `.java`):

    ```bash
    javac -d bin aplicacio/UsaLlistaEstacionsVE.java
    ```

2. Executa el programa:

    ```bash
    java -cp bin aplicacio.UsaLlistaEstacionsVE
    ```

---

## 📂 Estructura del projecte

- `aplicacio/` : paquet que conté la classe principal.  
- `dades/` : classes que defineixen i gestionen les estacions.  
- `EstacionsRecarregaReduit.csv` : fitxer CSV amb les dades de les estacions.

---

## 📋 Requisits

- Fitxer CSV correcte i present a la carpeta arrel.  
- Java JDK 8 o superior.

---

## 🤝 Col·laboracions

Si vols contribuir, fes un fork i envia un pull request.

---

## 📝 Autor

Jon Jordi Salvadó Pérez

---

## 📄 Llicència

MIT License.
