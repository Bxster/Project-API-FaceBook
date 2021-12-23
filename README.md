<div align="center">

![WhatsApp Image 2021-12-23 at 15 34 39-2](https://user-images.githubusercontent.com/92955826/147258306-3877f2b7-88c4-4a77-8c1e-5d16e4513a52.jpeg)

# Progetto-Programmazione-Ad-Oggetti 
  
</div>

### Descrizione in italiano :it:

L' applicazione SpringBoot permette, tramite l'API di Facebbok, di avere informazioni circa un utente, come il suo nome, il suo id o la sua e-mail e permette di avere statische riguardo gli album pubblicati dall'utente, filtrandoli in base all'anno, al mese o al giorno di pubblicazione, oppure cercandoli in base al nome. Grazie ad un Client, come ad esempio [Postman](https://www.postman.com), si può accedere alle funzionalità di questa applicazione usando le varie rotte rese disponibili.
Per far partire l'applicazione bisogna inserire il proprio Id e il proprio Access Token nel file di testo `WRITE_ME` nelle prime due righe; questi parametri si possono visualizzare attraverso il sito [Facebook for Developers](https://developers.facebook.com).

### Description of the project :england:

The SpringBoot application allows, through the Facebbok API, to have information about a user, such as his name, his id or his e-mail and allows you to have statistics about the albums published by the user, filtering them based on per year, month, or day of publication, or by searching for them by name. Thanks to a Client, such as [Postman](https://www.postman.com), you can access the functions of this application using the various routes made available.
To start the application you need to insert your Id and Access Token in the text file `WRITE_ME` in the first two lines; these parameters can be viewed on the [Facebook for Developers](https://developers.facebook.com).

### Plus del programma :heavy_plus_sign:

:white_check_mark: Inserimento di userId e userToken tramite file di testo WRITE_ME.txt

:white_check_mark: Controllo eccezioni lettura da file: file vuoto, file non esistente, token non corretto o scritto sulla riga sbagliata
                   
:white_check_mark: Ricerca albums in base al nome con controllo errori ed eccezioni

:white_check_mark: Ricerca albums non conformi alla  politica di Facebook, in base ad una lista di nomi inseriti in un file di testo
                   
:white_check_mark: Autoconfigurazione della porta del Server Tomcat per l'avvio di SpringBoot

:white_check_mark: Se, utilizzando un Browser Web, viene digitato male l'url o la chiamata di una rotta verrà visualizzata questa pagina di errore

![WhatsApp Image 2021-12-23 at 17 23 21](https://user-images.githubusercontent.com/92955826/147267373-ae865e87-e388-4864-854b-687b0c7eafd0.jpeg)

# Contenuti 📂

- [Configurazione](#configurazione-key)
- [Rotte](#rotte-dellapplicazione-airplane)
- [Parametri](#parametri)
- [Eccezioni](#eccezioni-)
- [Testo JUNIT](#test-junit-%EF%B8%8F) 
- [Struttura](#struttura-del-progetto-office)
- [Documentazione](#documentazione-)
- [Autori](#autori-del-progetto-it-smile)

# Configurazione :key:

Tramite il terminale del vostro pc potete clonare questa repository usando questo comando:

```
git clone https://github.com/lucabellantee/Progetto-programmazione-a-oggetti
```

Dopo di che si puo lanciare il progetto come SpringBoot application trmite un IDE, come [Eclipse](https://www.eclipse.org), oppure dal terminale e quando il programma sarà in esecuzione sarà possibile utilizzarlo tramite un client, come [Postman](https://www.postman.com), contattando l'indirizzo http://localhost:8080.

Ecco di seguito un video che spiega come scaricare e far funzionare questo programma: [video](https://www.youtube.com/watch?v=oE9Te12F10w)

# Rotte dell'Applicazione :airplane:

>Le richieste che l'utente può effettuare tramite Postman devono essere all'indirizzo 8080 a salire perché il nostro programma ha la funzionalità di cambiare la porta automaticamente se occupata fino ad arrivare alla porta 65535

**N°** | **Tipo** | **Rotta** | **Descrizione** | **Parametri**
--|--|:--:|--|--
[1](#prima-rotta-userinfo) | `GET` | `/userInfo` | Restituisce le informazioni principali dell'utente inserendo inoltre un parametro per ottenre un'informazione in particolare; i parametri accettati si possono trovare sul file di testo "GOOD_REQUEST.txt" | `param`
[2](#seconda-rotta-filter) | `GET` | `/filter` | Permette di inserire anno, mese o giorno per visualizzare quali album sono stati inseriti in quel lasso di tempo, facendo quindi statistiche | `year`, `month`, `day`
[3](#terza-rotta-filtername) | `GET` | `/filter/name` | Permette di inserire il nome di un album; se è presente nell'account allora verranno stampate a schermo le sue caratteristiche insieme a quelle dell'utente | `name`
[4](#quarta-rotta-filtervolgar-word) | `GET` | `/filter/volgar-word` | Tramite un file di testo chiamato "VOLGAR_NAME.txt" è possibile inserire una lista di nomi volgari e censurabili; lanciando questa get, se l'utente ha un album con uno di questi nomi verrà segnalato a schermo | No Parametri


### Parametri

Nelle rotte possono essere inseriti dei parametri per avere delle richieste specifiche sull'utente; questi parametri sono quelli che possono essere chiamati tramite [Facebook for developers](https://developers.facebook.com). Se viene insierito un parametro diverso o sbagliato, verrà visualizzato un errore. Questi parametri si possono trovare sul file di testo incluso nelle cartelle "GOOD_REQUEST.txt".

## Prima Rotta: /userInfo
La prima rotta restituisce un JSONObject, cioè l'elenco degli attributi dell'utente. Si deve inoltre inserire un parametro (`param`) per ottnere un'informazione aggiuntiva riguardo l'utente. Se viene inserito il nome di un parametro o il valore in modo incorretto verrà segnalato tramite degli errori. I parametri accettati sono quelli che si trovano all'interno del file di testo "GOOD_REQUEST.txt". Ecco un esempio di chiamata con il passaggio del parametro `age_range`

![Schermata 2021-12-21 alle 21 20 21](https://user-images.githubusercontent.com/92955826/146992620-85149647-7b59-43de-a788-c5797cab4d8b.jpg)

## Seconda Rotta: /filter
La seconda rotta restituisce un JSONObject contenente l'array degli album trovati per quel lasso di tempo scritto nei filtri come parametro, poi viene visualizato l'Id, il nome, l'e-mail dell'utente e inoltre il conto degli album trovati. Obbligatoriamente deve essere passato almeno un paramentro, cioè `year`, dopo di che a scelta si può inserire anche il mese(`month`) e poi il giorno(`day`); non si può inserire il giorno senza aver prima scritto il mese e l'anno, perchè, nel caso, verrebbe visualizzato a schermo un errore. Se vengono inseriti dei parametri incorretti, alterati o causali veranno visualizzati degli errori. Verrà tenuto conto del numero di giorni di ogni mese per evitare di non trovare nessun album in quel giorno perché non esiste il giorno.

>Con il passaggio del parametro `year`

![Schermata 2021-12-21 alle 21 10 57](https://user-images.githubusercontent.com/92955826/146992052-41b64739-1d6d-499a-89e0-c63821c99c63.jpg)
![Schermata 2021-12-21 alle 21 11 11](https://user-images.githubusercontent.com/92955826/146992057-266a0979-54b5-4f1c-b088-b5968ed4dfed.jpg)

>Con il passaggio dei parametri `year`, `month`

![Schermata 2021-12-21 alle 21 10 14](https://user-images.githubusercontent.com/92955826/146992003-acc1974c-c460-46fd-a511-dd21a11e2224.jpg)
![Schermata 2021-12-21 alle 21 10 31](https://user-images.githubusercontent.com/92955826/146992007-b0f1deba-da1f-4b52-bd3e-5bb9546a0100.jpg)

>Con il passaggio dei parametri `year`, `month`, `day`

![Schermata 2021-12-21 alle 21 09 48](https://user-images.githubusercontent.com/92955826/146991954-7cf1e748-bfe1-4c15-ad68-0fbf0a71278f.jpg)

## Terza Rotta: /filter/name

La terza rotta restituisce, se viene trovato l'album di cui abbiamo inserito il nome tramite il parametro `name`, un JSONObject contenente le infomarzioni riguardo quell'album e di seguito quelle riguardo l'utente. Nel caso non venga inserito nessun nome o il nome inserito non combaci con nessun album presente nell'account dell'utente, verranno segnalati a schermo degli errori.

>Con il passaggio del parametro `name`

![Schermata 2021-12-21 alle 21 21 14](https://user-images.githubusercontent.com/92955826/146992718-15c7e5ca-c2d7-4c69-99b7-84ebc4d10542.jpg)

## Quarta Rotta: /filter/volgar-word

La quarta rotta restituisce, se viene trovato un album con un nome volgare o censurabile segnalato nel file di testo `VOLGAR_NAME`, un JSONObject con le informazioni di quell'album e dell'utente; inoltre verrà mandato a schermo un link per segnalare la presenza di questo album alla polizia postale italiana. Inoltre se l'utente è minorenne verrà linkato anche il sito dei Servizi Sociali. Nel caso non venga trovato nessun album con un nome vietato verrà segnalato a schermo un errore. 

>Nel file di testo è stato inserito il vocabolo `Cavolo` e `Prova`

![Schermata 2021-12-21 alle 21 23 03](https://user-images.githubusercontent.com/92955826/146992877-30e40ca8-3b21-4f80-a4f8-7b728749d5b1.jpg)

# Eccezioni ❌

Oltre alle eccezioni standard di Java sono state gestite le seguenti eccezioni personalizzate:

>Eccezione BadParameterException:

Questa eccezione è presente in diverse classi del programma è viene lanciata se e solo sè:

- Al interno della prima rotta ("/userInfo") il valore del parametro passato non coincide con uno presente al interno del file di testo "GOOD_REQUEST.txt",       in questo caso il messaggio di errore sarà il seguente:
    
   - 1) "ATTENZIONE VALORE PARAMETRO IMMESSO NON VALIDO! CONTROLLARE LISTA VALORI PARAMETRI: GOOD_REQUEST.txt"

- I valori dei parametri passati alla seconda rotta("/filter"), ovvero sia: anno o anno/mese o anno/mese/giorno non siano ammissibili, es: year=3014    year=2021/month=15 o 2021/02/31 in questi casi viene lanciata l'eccezione personalizzata con i seguenti messaggi:
    
   - 1) messaggio in cui l'anno è errato(filtro per anno o anno/mese o anno/mese/giorno): "ANNO NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE"
   - 2) messaggio in cui il mese non è valido(filtro per anno/mese o anno/mese/giorno): "MESE NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE"
   - 3) messaggio in cui il giorno non è valido(filtro per anno/mese/giorno): "GIORNO NON VALIDO ! VERIFICA LA PRESENZA DI ALTRI ERRORI NEL CODICE"

ATTENZIONE : Con i filtri per anno/mese o anno/mese/giorno: non è detto che l'errore commesso sia solo il mese o il giorno o l'anno, l'eccezione verrà     lanciata durante la prima anomalia riscontrata, quindi se si filtra per anno/mese o anno/mese/giorno è bene verificare se sono presenti altri errori, ovvero ulteriori valori di parametri non ammissibili.
 

>Eccezione noAlbumsException:

Questa eccezione viene lanciata nel caso in cui l'utente non abbia alcun albums nel suo profilo. Questa situazione non dovrebbe capitare poichè facebook vieta di avere un profilo senza albums, infatti devono essere sempre presenti gli albums base come le immagini di profilo e di copertina , anche se vuoti. In ogni caso questa eccezione viene lanciata se in seguito ad un controllo risulta che l'utente non abbia nemmeno un album nel suo profilo. Il messaggio è il seguente: "NON E' PRESENTE ALCUN ALBUM"

 
>Eccezione noFileException:

Questa eccezione personalizzata viene lanciata se e solo sè:
    
 - Al interno del file "WRITE_ME.txt" l'utente inserisce lo userToken e l'accessToken su un'unica riga, il file sarà quindi composto da un' unica riga. 
   In questo caso il messaggio sarà: "ATTENZIONE ! TUTTE LE INFO SONO SU UN UNICA RIGA"
   
 - Al interno del file "WRITE_ME.txt" l'utente non inserisce l'accessToken splittato sulla seconda e terza riga. In questo caso il messaggio di errore sarà:
   "SBAGLIATO ! DEVI INSERIRE IL TOKEN SPLITTATO NELLA SECONDA E TERZA RIGA"
   
 - Al interno del file "WRITE_ME.txt" l'utente inserisce l'accessToken sulla seconda riga ma senza splittarlo, il file sarà quindi composto da sole due righe
   in questo caso l'errore sarà: "ATTENZIONE ! SPLITTA LO USER TOKEN NELLA SECONDA E TERZA RIGA"
   
 - Al interno del file "WRITE_ME.txt" l'accessToken splittato tra la seconda e la terza riga non è alfanumerico, in questo caso il messaggio di errore sarà
   il seguente: "ATTENTO , PROBABILMENTE NON HAI INSERITO CORRETAMENTE LO USER TOKEN"

# Test JUNIT ⚠️

>Ecco di seguito i test che vengono eseguiti su questo programma e visionabili [qui](https://github.com/lucabellantee/Progetto-programmazione-a-oggetti/tree/main/social/src/test/java/univpm/social)

### Classe testBadParameterException

![Schermata 2021-12-21 alle 21 32 36](https://user-images.githubusercontent.com/92955826/146995213-afce6d8f-cf73-4d34-905a-9b0cdf2d8433.jpg)
![Schermata 2021-12-21 alle 21 32 58](https://user-images.githubusercontent.com/92955826/146995219-4a79f8eb-0842-4226-a653-62efebcdeb83.jpg)
![Schermata 2021-12-21 alle 21 33 08](https://user-images.githubusercontent.com/92955826/146995220-83b442ea-a81f-457f-a60b-b3484e2d4b1e.jpg)
![Schermata 2021-12-21 alle 21 33 17](https://user-images.githubusercontent.com/92955826/146995222-0bd707fe-9a6c-4856-92bf-bb2fcb806761.jpg)
![Schermata 2021-12-21 alle 21 33 23](https://user-images.githubusercontent.com/92955826/146995224-943a5140-8871-43b3-a6a8-6502797255d9.jpg)

### Classe testFileExceptions

![Schermata 2021-12-21 alle 21 39 23](https://user-images.githubusercontent.com/92955826/146995225-889f58e5-10fd-4082-bd48-31348bd70fd0.jpg)
![Schermata 2021-12-21 alle 21 39 30](https://user-images.githubusercontent.com/92955826/146995227-4ad12bed-edeb-4eb2-bce3-c42cac660069.jpg)
![Schermata 2021-12-21 alle 21 39 38](https://user-images.githubusercontent.com/92955826/146995233-f92bcb79-70ab-4b58-ba96-dadec3d313ec.jpg)
![Schermata 2021-12-23 alle 14 56 35 copia](https://user-images.githubusercontent.com/92955826/147257590-4b119bf8-aa00-4194-bf3d-bd38a623e75f.jpg)
![Schermata 2021-12-23 alle 14 56 26 copia](https://user-images.githubusercontent.com/92955826/147257593-ea2e9687-37e2-4dbe-a6a8-8c60b1d326d7.jpg)

### Classe testFilterText

![Schermata 2021-12-21 alle 21 39 50](https://user-images.githubusercontent.com/92955826/146995235-783f10bf-7a57-4f40-90dc-dcf9e73750fe.jpg)
![Schermata 2021-12-21 alle 21 39 56](https://user-images.githubusercontent.com/92955826/146995236-0efab4d9-65f9-4fa2-8b59-a797027dc5a8.jpg)

### Classe testFilterTime

![Schermata 2021-12-21 alle 21 41 30](https://user-images.githubusercontent.com/92955826/146995238-2e23d931-af73-4d38-9bae-2261f866f584.jpg)
![Schermata 2021-12-21 alle 21 41 36](https://user-images.githubusercontent.com/92955826/146995239-277d60b7-b7d2-4b98-b910-6a58aef2c653.jpg)
![Schermata 2021-12-21 alle 21 41 42](https://user-images.githubusercontent.com/92955826/146995240-5fc5588d-a96e-4198-89f0-beaae7df139a.jpg)

### Classe testPortScanning

![Schermata 2021-12-21 alle 21 42 18](https://user-images.githubusercontent.com/92955826/146995242-9395afb0-0c8c-4941-97a1-00e331561e3a.jpg)

### Classe testTime

![Schermata 2021-12-21 alle 21 42 29](https://user-images.githubusercontent.com/92955826/146995243-2f5a1a76-6d60-4a77-b100-48c76cc18d34.jpg)
![Schermata 2021-12-21 alle 21 42 41](https://user-images.githubusercontent.com/92955826/146995245-c5164d79-f03f-4d7e-962b-40d12fcd3c45.jpg)

# Struttura del Progetto :office:

![Schermata 2021-12-23 alle 17 12 17](https://user-images.githubusercontent.com/92955826/147266698-e0491747-4e44-405b-b559-e3686bacae10.jpg)

![Schermata 2021-12-23 alle 17 12 48](https://user-images.githubusercontent.com/92955826/147266701-db53765f-2507-4961-849f-e15c74b7aa50.jpg)

![Schermata 2021-12-23 alle 17 13 13](https://user-images.githubusercontent.com/92955826/147266702-dad7eeb5-e9d5-49d4-889c-8f993f4ce02a.jpg)


# Documentazione 📰

Tutta la documentazione del codice java è integrato al programma tramite [JavaDoc](https://github.com/lucabellantee/Progetto-programmazione-a-oggetti/tree/main/social/doc)

# Autori del progetto :it: :smile:

Nome | Contributo
-- | :--:
[Baldelli Gianluca](https://github.com/Bxster) | Javadoc, ReadMe, Prova Applicazione, Segnalazione di Errori, Idee sul Model
[Bellante Luca](https://github.com/lucabellantee) | Sviluppo Software del programma, creazione di test dell'Applicazione e realizzazione video-tutorial
