# Planetarium 
Realizzato da _"Try-catch us"_ ---> _Mattia Cappa, Danis Halilovic, Luca Carbone_ 

## 1) Caratteristiche d'implementazione

### 1.1) Costituzione del sistema stellare
Nel nostro sistema stellare i corpi hanno determinate regole:
- Esiste solamente un'unica stella a cui ruotano attorno i pianeti
- Un pianeta può avere la stessa orbita di un altro pianeta ma non la stessa posizione della stella 
- Una luna (o satellite) può avere la stessa orbita di un'altra luna, ma non la stessa posizione del pianeta attorno a cui orbita
- Ogni pianeta a seconda della propria massa dispone di una forza di attrazione verso le lune, la quale determina la grandezza dell'orbita massima che può assumere una luna

### 1.2) Distanze e posizioni
- Il sistema stellare ha come riferimento la stella centrale che si trova di default in coordinate (0,0), essa rappresenta il centro del nostro sistema stellare
- La distanza tra corpi viene calcolata utilizzando la classica distanza euclidea in 2 dimensioni

### 1.3) Aggiunta e rimozione di un corpo
- La stella del nostro sistema stellare verrà aggiunta all'avvio del nostro programma e non potrà essere mai rimossa
- I pianeti cosi come le lune potranno essere aggiunti e rimossi a piacere dall'utente
- La rimozione di un pianeta causerà a cascata la rimozione delle sue lune

### 1.4) Dimensioni
- Lo spazio ha dimensione 100x100
- La stella ha massa minima pari a 20 e massima pari a 40
- La massa di un pianeta non può superare la massa della stella e cosi vale anche tra luna e pianeta

### 1.5) Collisioni
Precedentemente, nella sezione "Costituzione del sistema stellare", è stato specificato che le lune e i pianeti possono avere orbite uguali; ciò serve ad identificare il primo tipo di collisioni 
. Oltre alle collisioni basiche appena descritte possiamo trovare le varie collisioni che le lune possono generare:
- Collisione Luna-Luna appartenenti a pianeti diversi
- Collisione Luna-Pianeta
- Collisione Luna-Stella

Il nostro programma a richiesta dell'utente fornisce una lista di pianeti e lune che sono in collisione.

## 2) Funzionamento del programma

### 2.1) Ciclo principale
Il programma all'avvio stampa a video un messaggio di benvenuto e fa creare automaticamente all'utente una stella. In seguito, dopo essere entrato nel ciclo di esecuzione principale, stampa il menù comandi permettendo all' utente di comprendere come modificare il sistema stellare e come orientarsi all'interno del programma

### 2.2) Navigazione nei menù
La posizione dell'utente viene indicata tra le due tildi accanto al cursore 
- "home": indica che tri trovi nel menù principale da dove puoi entrare nelle sottosezioni digitando gli appositi comandi descritti nel menù
- "+": indica che ti trovi nel menù aggiunta corpo
- "-": indica che ti trovi nel menù rimozione corpo
