# StoreApplication

StoreApplication è un'applicazione per la gestione di un piccolo store. È sviluppata con:

- **Backend**: Spring Boot
- **Frontend**: React + Vite
- **Database**: Oracle Database

## Requisiti

Prima di avviare l'applicazione, assicurati di avere i seguenti requisiti:

- **Java 17**: è necessario per eseguire il backend. Puoi scaricarlo da [Oracle](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
- **XAMPP**: è necessario per eseguire Apache (se utilizzato nel progetto). Puoi scaricarlo da [XAMPP](https://www.apachefriends.org/index.html).

## Istruzioni per l'esecuzione

1. **Configurazione dei percorsi**: Prima di eseguire qualsiasi comando, assicurati di avere configurato correttamente i percorsi di `backend`, `frontend` e `storedb` nel tuo ambiente locale. I percorsi devono corrispondere a quelli presenti nel progetto.

2. **Avvio del Backend**:
   - Naviga nella cartella `backend`.
   - Esegui il comando per avviare il backend con Spring Boot:
     ```bash
     java -jar store.jar
     ```
   - Questo avvierà l'applicazione backend e sarà disponibile sulla porta configurata (di default, sulla porta 8080).

3. **Avvio del Frontend**:
   - Naviga nella cartella `frontend`.
   - Assicurati di avere tutte le dipendenze installate:
     ```bash
     npm install
     ```
   - Avvia il frontend con il comando:
     ```bash
     npm run dev
     ```
   - Questo avvierà il server di sviluppo frontend, di solito sulla porta 5173.

4. **Avvio di Apache con XAMPP**:
   - Apri XAMPP e avvia il server Apache.
   - Una volta avviato Apache, il sito sarà accessibile su `http://localhost/store/`.

5. **Database Oracle**:
   - Assicurati di avere il database Oracle correttamente configurato e che il file SQL presente in `storedb/` sia importato nel tuo database.

6. **Verifica**:
   - Dopo aver avviato sia il backend che il frontend, apri il browser e vai all'URL `http://localhost/store/` per accedere all'applicazione.

## Struttura del progetto

- `backend/`: Contiene il codice sorgente del backend sviluppato con Spring Boot.
- `frontend/`: Contiene il codice sorgente del frontend sviluppato con React e Vite.
- `storedb/`: Contiene il file SQL per il database Oracle.

## Licenza

Distribuito sotto la [licenza MIT](LICENSE).
