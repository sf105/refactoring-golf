# Refactoring Golf

_Refactoring Golf_ è un gioco concepito per essere l'equivalemte dello stretching
per i 'muscoli' della rifattorizzazione, nonchè per spingervi a scoprire quello che
il vostro IDE può fare con scorciatoie e automatismi. L'idea è quella di concentrarsi
su un aspetto specifico del processo di codifica e capire fin dove ci si può spingere.

Questo repo contiene svariate versioni di una classe che ha come scopo quello di calcolare
le tasse (IRPEF) di una busta paga.

* I primi 5'000€ sono esentasse
* Lo scaglione sino a 20'000€ è tassato al 10%
* Lo scaglione sino a 40'000€ è tassato al 20%
* Oltre i 40'000€ le tesse sono al 40%

(I valori indicati sono di fantasia - non fanno riferimento ad alcun aspetto legale)-

Ogni versione è una rifattorizzazione delle versione precedente. Applicando la metafora del gioco
del golf, ogni versione è chiamata "buca".

L'obiettivo è di rifattorizzare ogni _buca_ nella versione successiva nel modo più sicuro
ed efficiente, utilizzando le potenzialità dell'IDE con il minor numero di "colpi" possibili.
Un _colpo_ è definito come una azione che modifica il codice; ogni colpo costa punti.

Il vostro compagno dovrà annotare con cura il vostro punteggio nel modo seguente:

- 0 punti per formattazione e selezione
- 1 punto for ogni mdofica effettuata utilizzando una scorciatoia o una caratteristica dell'IDE
(esempio: refactoring automatica, template di codice, rename, Find/replace).
- 2 punti per ogni modifica manuale. Notare che una singola modifica può comprendere più linee di codice.
- Nel caso che la modifica porti a un codice che fa fallire i test, la penalità è _raddoppiata_

Avete a disposizione 2 tentativi per ogni round per determinare il punteggio migliore.

## Suggerimenti
- Ogni versione possiede un file chiamato `istruzioni.md` che desrive le motivazioni alla base del prossimo refactoring.
- Potrebbe essere una buona idea tenere aperto il codice su un'altra finestra, o anche sul computer del partner.
È facile perdersi quando si lavora su più file.
- Committate il codice frequentemente, specialmente dopo ogni stadio di refactoring. Ciò faciliterà un eventuale
rollback nel caso vogliate fare un secondo tentativo o vi perdiate.
- Lanciate i test dopo ogni "colpo" - per farlo basta selezionare la cartella superiore di  *refactoring-golf* in
nella vista progetto e selezionare `Run 'All Tests'` dal menu pop-up.
- Controllate spesso il vostro codice in modo che sia facile tentare un refactoring più di una volta. Idea ha anche
un'ottima  so it's easier to try a refactoring more than once. Idea ha anche una opzione (_Local History_) che può risultare utile.

## Pratica (IDE)
- L'esercizio è stato scritto con _Intellj Idea_. Dovreste riuscire facilmente a clonare il repo e aprirlo
 (_Open_) come progetto.
- Idea ha una _Keymap Reference_ disponibile dal menu di aiuto. Se non lo conoscete, vale la
pena leggerlo e tenerlo a portata di mano.
- Per iniziare va benissimo usare il mouse, ma cercate di imparare le scorciatoie di tastiera.
- Non dovrebbero esserci problemi di sorta usando altri IDE (Eclipse, VS, VSC, Netbeans), ma l'importazione va fatta 
manualmente e potrebbero essere necessari aggiustamenti

#Pratica (Repl)
- L'esercizio è stato adattato per essere usato online tramite Repl.it. Importate questo repo in Repl.it e tutto 
dovrebbe funzionare. 
- Lanciando il main si lanciano i test della buca 1. Per cambiare buca basta modificare il parametro 
passato a TestRunnen, nel medoto Main.

## Esempio di punteggi
Ecco qualche esempio di punteggio, ottenuto tramite IntelliJ.  

<table border="1">
<tr><th>Buca</th><th>Punteggio migliore</th><th>Note</th></tr>
<tr><td> 1    </td><td> 6          </td><td></td></tr>
<tr><td> 2    </td><td> 3          </td><td></td></tr>
<tr><td> 3    </td><td> 9          </td><td></td></tr>
<tr><td> 4    </td><td> 17         </td><td>molti editing manuali</td></tr>
<tr><td> 5    </td><td> 13         </td><td></td></tr>
<tr><td> 6    </td><td> 14         </td><td></td></tr>
<tr><td> 7    </td><td> 29         </td><td>Piuttosto difficile, ma fattibile</td></tr>       
<tr><td> 8    </td><td> 8          </td><td></td></tr>
<tr><td> 9    </td><td> xx         </td><td></td></tr>
</table>       

## Versioni alternative
La versione in inglese è presente nel branch `main`.

Troverete anche una versione alternativa implementata da zero con TFF nel branch  
`reimplemented-with-tdd` del repo

## Crediti
Gran parte di questo esercizio è stato preso da Lance Walton.

Altre idee sono prese da David Denton e Ivan Sanchez, ispirati da @ivanmoore e @rchatley

Le istruzioni sono state per lo più rubate da @jasongorman:  
<a href="https://github.com/jasongorman/RefactoringGolfJava">Refactoring Golf</a>.


## Notes

- Usiamo`double` per i calcoli. Usare i floating point è in genere una pessima idea per memorizzare il denaro; qui
 lo abbiamo fatto per semplificare l'esercizio. La versione alternativa con TDD usa i `long`.
 In entrambi i casi si dovrebbero usare i formati decimali.

- questa traduzione è stata fatta da @piffy
