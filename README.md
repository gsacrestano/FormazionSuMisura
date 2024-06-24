# Formazione Su Misura

Formazione Su Misura è un applicativo Java creato per testare una base di dati progettata per l'esame di Basi di Dati. L'applicativo permette di interagire con la base di dati, eseguire query e testare diverse operazioni.

## Struttura del Progetto

Il progetto è organizzato come segue:

- `src/` - Contiene il codice sorgente dell'applicativo Java
- `Image/` - Contiene le immagini dell'applicativo Java
- `src/database/` - Contiene lo script per la creazione del DataBase


## Requisiti

- JDK 11 o superiore
- Un database compatibile (ad esempio, MySQL)
- Maven (opzionale, per la gestione delle dipendenze)

## Installazione

1. Clona il repository del progetto:
    ```sh
    git clone https://github.com/tuo-username/FormazioneSuMisura.git
    ```
2. Naviga nella directory del progetto:
    ```sh
    cd FormazioneSuMisura
    ```
3. Compila il progetto utilizzando Maven:
    ```sh
    mvn clean install
    ```

## Configurazione
 Configura il file src/main/java/org/example/dbConnection/ConnectionDB.java
```
Connection con = DriverManager.getConnection(url, "Your-username", "Your-password");
 ```
