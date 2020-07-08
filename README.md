# Pathfinding

Project that uses different pathfinding algorithms and compares they results against different maps.

## Algorithms

- Deep find
- Breadth first search
- Bellman Ford
- Dijkstra
- A*

## Maps

First map: From [0][0] to [9][9]
```
"..  XX   ."

"*.  *X  *."

" .  XX ..."

" .* X *.* "

" ...=...  "

" .* X     "

" .  XXX*  "

" .  * =   "

" .... XX  "

"   *.  X* "
```

Second map: from [0][0] to [9][19]

```
"...*     X .*    *  " 
" *..*   *X ........."  
"   .     =   *.*  *." 
"  *.   * XXXX .    ." 
"XXX=XX   X *XX=XXX*." 
"  *.*X   =  X*.  X  " 
"   . X * X  X . *X* " 
"*  .*XX=XX *X . XXXX" 
" ....  .... X . X   " 
" . *....* . X*. = * "
```
"[blank]" = Grass. Cost 2 move
"[*]" = Tree. Can't go throught them
"[=]" = Bridge. Cost 2 move
"[X]" = Water. Can't go throught them
"[.]" = Road. Cost 1 move

## Results

### Map 1
Algorithm: Deep

Path (size: 68.0):[9;9;Grass]-[8;9;Grass]-[7;9;Grass]-[6;9;Grass]-[5;9;Grass]-[4;9;Grass]-[3;9;Grass]-[2;9;Road]-[1;9;Road]-[0;9;Road]-[0;8;Grass]-[0;7;Grass]-[1;7;Grass]-[2;7;Road]-[3;7;Road]-[4;7;Road]-[5;7;Grass]-[5;6;Grass]-[5;5;Grass]-[4;5;Road]-[4;4;Bridge]-[4;3;Road]-[5;3;Grass]-[6;3;Grass]-[7;3;Grass]-[8;3;Road]-[8;2;Road]-[9;2;Grass]-[9;1;Grass]-[9;0;Grass]-[8;0;Grass]-[7;0;Grass]-[6;0;Grass]-[5;0;Grass]-[4;0;Grass]-[3;0;Grass]-[2;0;Grass]-[2;1;Road]-[1;1;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 14

Algorithm: Breadth

Path (size: 29.0):[9;9;Grass]-[8;9;Grass]-[8;8;Grass]-[7;8;Grass]-[6;8;Grass]-[5;8;Grass]-[5;7;Grass]-[5;6;Grass]-[5;5;Grass]-[4;5;Road]-[4;4;Bridge]-[4;3;Road]-[4;2;Road]-[4;1;Road]-[3;1;Road]-[2;1;Road]-[1;1;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 2

Algorithm: Bellman-Ford

Path (size: 27.0):[9;9;Grass]-[8;9;Grass]-[7;9;Grass]-[6;9;Grass]-[5;9;Grass]-[4;9;Grass]-[4;8;Grass]-[4;7;Road]-[4;6;Road]-[4;5;Road]-[4;4;Bridge]-[4;3;Road]-[4;2;Road]-[4;1;Road]-[3;1;Road]-[2;1;Road]-[1;1;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 3

Algorithm: Dijkstra

Path (size: 27.0):[9;9;Grass]-[8;9;Grass]-[7;9;Grass]-[6;9;Grass]-[5;9;Grass]-[4;9;Grass]-[4;8;Grass]-[4;7;Road]-[4;6;Road]-[4;5;Road]-[4;4;Bridge]-[4;3;Road]-[4;2;Road]-[4;1;Road]-[3;1;Road]-[2;1;Road]-[1;1;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 3

Algorithm: A*

Path (size: 27.0):[9;9;Grass]-[8;9;Grass]-[7;9;Grass]-[6;9;Grass]-[5;9;Grass]-[4;9;Grass]-[4;8;Grass]-[4;7;Road]-[4;6;Road]-[4;5;Road]-[4;4;Bridge]-[4;3;Road]-[4;2;Road]-[4;1;Road]-[3;1;Road]-[2;1;Road]-[1;1;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 2

### Map 2

Algorithm: Deep

Path (size: 77.0):[9;19;Grass]-[8;19;Grass]-[8;18;Grass]-[8;17;Grass]-[9;17;Grass]-[9;16;Bridge]-[9;15;Grass]-[8;15;Grass]-[7;15;Grass]-[6;15;Grass]-[5;15;Grass]-[5;14;Road]-[4;14;Bridge]-[3;14;Road]-[2;14;Road]-[1;14;Road]-[1;13;Road]-[1;12;Road]-[2;12;Grass]-[2;11;Grass]-[2;10;Grass]-[2;9;Bridge]-[2;8;Grass]-[3;8;Grass]-[4;8;Grass]-[5;8;Grass]-[5;9;Bridge]-[5;10;Grass]-[6;10;Grass]-[7;10;Grass]-[8;10;Road]-[8;9;Road]-[8;8;Road]-[8;7;Road]-[9;7;Road]-[9;6;Road]-[9;5;Road]-[8;5;Grass]-[8;4;Road]-[8;3;Road]-[7;3;Road]-[6;3;Road]-[5;3;Road]-[4;3;Bridge]-[3;3;Road]-[2;3;Road]-[1;3;Road]-[1;2;Road]-[0;2;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 2

Algorithm: Breadth

Path (size: 53.0):[9;19;Grass]-[8;19;Grass]-[8;18;Grass]-[8;17;Grass]-[9;17;Grass]-[9;16;Bridge]-[9;15;Grass]-[9;14;Road]-[8;14;Road]-[7;14;Road]-[6;14;Road]-[5;14;Road]-[4;14;Bridge]-[3;14;Road]-[2;14;Road]-[1;14;Road]-[1;13;Road]-[1;12;Road]-[1;11;Road]-[1;10;Grass]-[2;10;Grass]-[2;9;Bridge]-[2;8;Grass]-[2;7;Grass]-[2;6;Grass]-[2;5;Grass]-[2;4;Grass]-[2;3;Road]-[2;2;Grass]-[2;1;Grass]-[2;0;Grass]-[1;0;Grass]-[0;0;Road]

Duration (ms): 11

Algorithm: Bellman-Ford

Path (size: 49.0):[9;19;Grass]-[8;19;Grass]-[8;18;Grass]-[8;17;Grass]-[9;17;Grass]-[9;16;Bridge]-[9;15;Grass]-[9;14;Road]-[8;14;Road]-[7;14;Road]-[6;14;Road]-[5;14;Road]-[4;14;Bridge]-[3;14;Road]-[2;14;Road]-[1;14;Road]-[1;13;Road]-[1;12;Road]-[1;11;Road]-[2;11;Grass]-[2;10;Grass]-[2;9;Bridge]-[2;8;Grass]-[2;7;Grass]-[2;6;Grass]-[2;5;Grass]-[2;4;Grass]-[2;3;Road]-[1;3;Road]-[1;2;Road]-[0;2;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 2

Algorithm: Dijkstra

Path (size: 49.0):[9;19;Grass]-[8;19;Grass]-[8;18;Grass]-[8;17;Grass]-[9;17;Grass]-[9;16;Bridge]-[9;15;Grass]-[9;14;Road]-[8;14;Road]-[7;14;Road]-[6;14;Road]-[5;14;Road]-[4;14;Bridge]-[3;14;Road]-[2;14;Road]-[1;14;Road]-[1;13;Road]-[1;12;Road]-[1;11;Road]-[1;10;Grass]-[2;10;Grass]-[2;9;Bridge]-[2;8;Grass]-[2;7;Grass]-[2;6;Grass]-[2;5;Grass]-[2;4;Grass]-[2;3;Road]-[1;3;Road]-[1;2;Road]-[0;2;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 3

Algorithm: A*

Path (size: 49.0):[9;19;Grass]-[8;19;Grass]-[8;18;Grass]-[8;17;Grass]-[9;17;Grass]-[9;16;Bridge]-[9;15;Grass]-[9;14;Road]-[8;14;Road]-[7;14;Road]-[6;14;Road]-[5;14;Road]-[4;14;Bridge]-[3;14;Road]-[2;14;Road]-[1;14;Road]-[1;13;Road]-[1;12;Road]-[1;11;Road]-[1;10;Grass]-[2;10;Grass]-[2;9;Bridge]-[2;8;Grass]-[2;7;Grass]-[2;6;Grass]-[2;5;Grass]-[2;4;Grass]-[2;3;Road]-[1;3;Road]-[1;2;Road]-[0;2;Road]-[0;1;Road]-[0;0;Road]

Duration (ms): 2

