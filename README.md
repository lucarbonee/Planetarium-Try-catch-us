# Planetarium di _"Try-catch us"_

### 1) Costituzione del sistema stellare
Nel nostro sistema stellare i corpi hanno determinate regole:
- Esiste solamente un'unica stella a cui ruotano attorno i pianeti
- Un pianeta non può avere la stessa orbita di un altro pianeta
- Una luna (o satellite) non può avere la stessa orbita di un'altra luna
- Ogni pianeta a seconda della propria massa dispone di una forza di attrazione verso le lune, la quale forza determina la grandezza dell'orbita massima che può assumere una luna

### 2) Distanze e posizioni
- Il sistema stellare ha come riferimento la stella centrale che si trova in coordinate (0,0), essa rappresenta il centro del nostro sistema stellare
- La distanza tra corpi viene calcolata utilizzando la classica distanza euclidea in 2 dimensioni

### 3) Aggiunta e rimozione di un corpo
- La stella del nostro sistema stellare verrà aggiunta all'avvio del nostro programma
- I pianeti cosi come le lune potranno essere aggiunti a piacere dall'utente
- La rimozione di un pianeta causerà a cascata la rimozione delle sue lune
