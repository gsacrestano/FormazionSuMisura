# Formazione Su Misura

Formazione Su Misura è un applicativo Java creato per testare una base di dati progettata per l'esame di Basi di Dati. L'applicativo permette di interagire con la base di dati, eseguire query e testare diverse operazioni.

## Struttura del Progetto

Il progetto è organizzato come segue:

- `src/` - Contiene il codice sorgente dell'applicativo Java
- `Images/` - Contiene le immagini dell'applicativo Java


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

Configura il file `resources/config.properties` con le informazioni della tua base di dati:

```properties
db.url=jdbc:mysql://localhost:3306/tua_base_di_dati
db.username=tuo_username
db.password=tuo_password
