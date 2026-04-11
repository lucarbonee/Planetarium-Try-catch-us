# Planetarium 
Realizzato da _"Try-catch us"_ ---> _Mattia Cappa, Danis Halilovic, Luca Carbone_ 

## 1) Caratteristiche d'implementazione

### 1.1) Costituzione del sistema stellare
Nel nostro sistema stellare i corpi hanno determinate regole:
- Esiste solamente un'unica stella a cui ruotano attorno i pianeti
- Un pianeta può avere la stessa orbita di un altro pianeta 
- Una luna (o satellite) può avere la stessa orbita di un'altra luna
- Ogni pianeta a seconda della propria massa dispone di una forza di attrazione verso le lune, la quale determina la grandezza dell'orbita massima che può assumere una luna

### 1.2) Distanze e posizioni
- Il sistema stellare ha come riferimento la stella centrale che si trova di default in coordinate (0,0), essa rappresenta il centro del nostro sistema stellare
- La distanza tra corpi viene calcolata utilizzando la classica distanza euclidea in 2 dimensioni

### 1.3) Aggiunta e rimozione di un corpo
- La stella del nostro sistema stellare verrà aggiunta all'avvio del nostro programma
- I pianeti cosi come le lune potranno essere aggiunti a piacere dall'utente
- La rimozione di un pianeta causerà a cascata la rimozione delle sue lune

## 2) Funzionamento del programma

### 2.1) Ciclo principale
Il programma all'avvio stampa a video un messaggio di benvenuto e fa creare automaticamente all'utente una stella  
in seguito ,dopo essere entrato nel ciclo di esecuzione principale, stampa il menù comandi permettendo all' utente di comprendere come modificare il sistema stellare

### 2.2) Navigazione nei menu'
La posizione dell'utente viene indicata tra le due tildi accanto al cursore 
- "home": indica che tri trovi nel menù principale da dove puoi entrare nelle sottosezioni digitando gli appositi comandi descritti nel menù
- "+": indica che ti trovi nel menù aggiunta
- "-": indica che ti trovi nel menù rimozione
- "cerca": indica che ti trovi nel menù cerca