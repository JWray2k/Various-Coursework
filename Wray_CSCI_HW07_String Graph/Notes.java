/**
 *
 * @author jw91482
 */
public class Notes {
    
}

/*
Notes:

From Hash values: (A13)
-   If there is a gap (b/c we deleted somthing) + we go to retrieve another value,
    it will stop on the empty box b/c it thinks its not been put in the list.
    1. occupied has no value
    2. empty never had value
    3. delted, had value

Quadratic probing = f(i) = i^2
    i/0 = (hash(key) + i^2) % tableSize     (1st spot)
          (has(key) % tableSize
          hash(key) % tableSize

    i/1 = hash(key) + (1^2) % tableSize = hash(key) + 1 % tabSize 
    i/2 = "    "    " (2^2) "       " = HASH(KEY) + 4 % tabSize
    1/3 = "    "    " (3^2) "   "   "   

Class map (A9)
              0      1       2   -> connects the things that go together
Array Keys    3      4       7
    Values  "cat" "house" "Street"

Make an object        0           1           2
                  'map item'  'map item'  'map item'
                  key is:
                  value cat

    mapitem{
        E key
        F key
    }

Hashing (A9) -> take a key + trn it into an address where the value is stored (location)
        0          n-1
Array [[ ][ ][ ][ ][ ]]
        ^                   (4,cat)
       Hash Funct <- key
    - h is our hash function
    - if 2 keys map to the same spot (BAD) - collision - h(k) = h(k)

Hash Function has 2 parts
    1) Turn key into an int Hash code
    2) Get an index from that int 0 -> n-1 compression

1. turn it into an int
2. map it to something the size of the list
3. once you get your # do modular arithmmatic

(A18)
Command: at each time slice (every time you see this, ceate a new job + set the start time)
- you have a big text file w/ 2 commands
    - name + length -> get read into the job
- the rest of the job items get calculated

Input is the constructor for the simulator

* have an arrayList, pull all the lines out of the tile + close the file
    - method -> get next command (if there are no more commands, send back 
    "no new job this slice") <- 50x5
-> If no file name is provided -> uuse Dr. Lillis to the the the array list(?)

    while the job is being executed

* boolean var idlethistimeslice
        if I execute antthing = TRUE

Pub. Int -> CPU Sim() -> Output sent to the screen
CPU Sim -> spec the comp

4, comparitor to use, where to get inst. From, where to put the output

Main Method - create a simulatior + start the proj
- add a method to the comparitor called getName
- add method to update the values of (ideas?)
- extend the heap, in

(A6)
Make another comp

String Comparitor vowels implements Comp<str>

    pub int compare(String sl, String s2){
        StringS vowels1 = "  ";
        for(int i = n; i < s1.length(); i++){
            if(isVowel(" " +s1.CharAt(i)))){
                Vowels1 += S1.CharAt(i);

    String vowels1 = get Vowels1(s1); return vowels1.compare
    "           "2 = "         2(s2);   to(2);

    private boolean isVowel(Sting - ch){
        returns("aeiouAEIOU".contains(ch)

private string getVowels(String S){
        StringS vowels1 = "  ";
        for(int i = n; i < s1.length(); i++){
            if(isVowel(" " +s1.CharAt(i)))){
                Vowels1 += S1.CharAt(i);

        return vowels;
}

New Int Comp

    pub int compt Reverse(Integer num1, Integer num2){
        if(num1 < num2){
            return 1;
        if(num1 > mum2){
            return -1;
        else
            return 0;


(A16)
Inversion - If I have two elements that are out of order, that's an inversion
        [3][2][5][4]
         <-->  <-->

{34, 8, 64, 51, 32, 21} - List the inversions
                          (34,8)(64,51)(51,32)
                9 total   (34,32)(64,32)(51,21)
                          (34,21)(64,21)
- What's the smallest # of inv we can potentially have?
    - Avg # of inv in a randomly sorted array?

{1,2,3} = can arrange these n!, 3!, or 3*2*1

123 0   312 2   # inversions
132 1   321 3
213 1               Avg # of inversions is always
231 2               n*n-1 = n^2-1 
avg 1.5              /4      /4    = (1/4)(n^2) - (1/4n)

Any runtime that sorts by swapping Adjacent elements requires 0(n^2)time
    if the avg requ. the worst case requ.at least this

Merge Sort      1 part breaks the list down into smaller + smaller
 elements.      [[3][2][1][3][4][7][5][6]]                  3  2     1  3       4  7     5  6
*n(log n)       [[ ][ ][ ][ ]]      [[ ][ ][ ][ ]]          \  /     \  /       \  /     \  / 
^- Sort         [[ ][ ]]  [[ ][ ]]  [[ ][ ]]  [[ ][ ]]    [[2][3]] [[1][3]]   [[4][7]] [[5][6]]
                [3] [2]    [1] [3]   [4] [7]   [5] [6]        \       /           \       /
                                                            [[1][2][3][3]]      [[4][5][6][7]]
                                                                      \           /
                                                                     1 2 3 3 4 5 6 7

(A15)
)tester one) * comp can be in here (3 def ones)
main( )
    comparitor<String> = new myComparitor
Give it to -> Generic Heap<String> h = new Generic Heap<>(comp);

- Make a String comp

in my const -> In heap pub Heap (Compare comp)
            Compare = comp
    bubble up + bubble down for add + remove
Sorting         [[5][4][3][2][1]] if two things are out of order
    switch =>     4  5
Bubble Sort          3  5       highest values has bubbled to the top
                        2  5   /
                           1  5
    - we do this 4 times... O(n^2)
    - we can do our compare one more time but
      not compare the final, then as you go stop comp the last, which is O(n^2)
    ______/ O(n^2)
    _____/
    ____/
    ___/
    __/
    _/

Selection Sort + Insertion Sort (n^2 both)
                            <------->           - Pick something
    Selection ->   [[ ][ ][ ][ ]|[ ][ ][ ][ ]]  - swap
                     ^sorted      ^not sorted

Insertion Sort
                   [5][7][3][4][7]  - take 2, put it next to 5
                   [3][2][3][4][7]  - check if 2 is in right spot
                   [2][5][3][4][7]  - if not, swap it so it's right.

(A14)
hash fun = %TS(tab Size                                            Increments
            Insert                                                /
0 [ 96]       3                                        64 % 10 + 1^2 = 5
1 [   ]       6                                        64 % 10 + 2^2 = 8
2 [   ]       55                       
3 [  3]       129                                      263 % 10 + 1^2 = 4
4 [ 13]       13    = 13 % 10+1 = 4                    263 % 10 + 2^2 = 7
5 [ 55]       64    = 64 % 10+1 = 5                    (hash(key)+i^2) % 10
6 [  6]       263   = 263 % 10 + 0^2 = 3                 key%10
7 [263]       96    (hmm... not sure what this is)     (96 % 10 + 0^2) % 10 =
8 [ 64]                                                (96 % 10 + 1^2) % 10 = 1 (or 7?)
9 [129]                                                (96 % 10 + 2^2) % 10 = 0

Double Hashing:
f(0) -> f(i) = i * (hash2(key))  //i think this 2 is supposed to be subscript...
        important not to have hash(key) = 0
        b/c then your not probing forward at all

Common function for double hashing:
    hash2(key) = R-(key % R), where R is the largest
prime less than table size.

rehashing = if the table is too full, make a bigger table
-> grab every value out of old table + put it in

Generic Heap <E>        Generic Comp <E>


(A19)
- As jobs finish -> put it in an array list to calculate ag waste time for all the jobs.

Matrix
          n             if we store all the values
    -------------       including zeros, space req. is
    |           |       O(m*n)
  m |           |       
    |           |       If we don't store all the zeros
    |           |       space req. is O(k), where k is
    -------------       the number of non-zero entries
   ^
   /
  (refer to 2nd page of handout on website)

   2D array of int. each int 32 bits
    0  1               - treat each bit as a T/F val
  0[ ][ ][ ][ ]
  1[ ][ ][ ][ ]
    32 Col
     2 Row

A Graph G made up of 2 sets, G=(V,E)
    A -------- B                V = {A, B, C, D, E, F, G,}
      \      /                  E = {{A,B},{A,C},{B,C}
       \    /                       {G,F},{G,E},{F,E},{D,E}}
        \  /   G
         \/    /\
          C   /  \              N(subscript G),(E) = {G,F,D}
             /    \                 deg(E) - |N(subscript G)(E)|
            /      \
           F--------E---D       closed Neighborhood = N(subscript G)[E] = {E,D,F,G


(A17)
Quick Sort -> n(logn)
              [[5][6][7][7][20]]    - Grab the 5
              [[2][5][6][7][8]]     - Rearrang to its correct position
                   ^
                   is always right but to the right of left of it is not necessarily in order
                   - Key is to take the best to start with

    a1  a2  a3                      worst case = height of tree
        a1   <   a2                     n(logn)
        /         \                 *best you can ever do for sorting root.
    a2 < a3      F a1  <  a3
     T /  \ F      /        \ F              
     a1 a2 a3   a2 a1 a3     a1  <  a3
                            /         \
            (a1<a3)      a2 a3 a1   a3,a2,a1
        T          \ 
     a1 a3 a2       F  a3 a1 a2


CPU - use lillis heap... we have a pool of jobs
                        cpu - time slice grabs a job executes it, puts it back
    (circle)               
                        start time = just a counte length / exec time = same?
                slice #7
  100   A want time update  (Begins / Requires)(?)
        B ----------------> B updates exection time
        C want time update
        D want time update

- so they bobble up and down correctly


(A...)

  0  1  2  3  4  5  6  7
[[I][ ][ ][D][E][F][G][H]]
  R        F

boolean isEmpty( ){
    return F==R;
}

when R is empty +

boolean isFull ( )
    return (r+1) % Q.length == F            (r+1)       (7)
                                              & & 0.lens = 0 == F
int size( ){                                                   (e)
    return (Q.length - F + R) % length
        8 - 3 + 1 % 8
            6 % 8
              = 6

Trees!
- If a tree isn't empty special node called root.
- root can have zero or more children
    (root)      - subtrees
   / |  | \     - every node other than the root has 1 parent
 ( )( )( )( )
    - path, is where you start + walk along
    - A -> B Path
    - length = 1 - numb nodes
    - depth of node = length of path from node to root


(A12)                       Add a count to each Linked list value
                    Keep                Remove
0[ ]                13 % 10 = 3         17
1[ ]    3           26      = 6        -97
2[ ]   x            43      = 3       / 26
3[.]-[13]-[43]      13      = 3      /  13
4[ ]                97      = 7 <---/  -26
5[ ]                26      = 6 <-----/
6[ ]-[26]           13      = 3
7[ ]-[97]
8[ ]
9[ ]
     Remove
    x if we find it w/ a # that is > 1, dec. the #
   "    "   "   "   w/ a # "   "   = 1, remove from linked list
   "    "   "   "   "   "   "     not there, do nothing

Hashing w/o linked list: Probing
    - Resolving collisions: w/o sep. chainging
    - if we go to put something there and its full, we probe to find the next spot

    [  ]
    [  ]                                    #fun = nub % 10
13~>[13]<~23(no, find a                         if something there
    [  ]    different spot) 0[   ]      12      Add 2 to loc.
    [  ]                    1[   ]      22     *make it a prime #
    [  ]                    2[ 12]      32
                            3[   ]      28
                            4[ 28]     100
                            5[   ]      76
                            6[ 38]
                            7[   ]
                            8[ 28]
                            9[   ]
                           10[100]
                           11[   ]


(A10)
convert key to an int ->
    - Do not need to  be in-range 0->(n-1)
- If our key is an int already -> h(k) = k
- if the # of lots in our # matched ->          take 32 bits+
  turn into an int C# -> (int)char (int)byte (int)Short

    float.floatTIntBits(k)

if key has more bits than an int, truncate it       Long(64) to int(32)
          64 bits
        [   ][   ]---\
          \->[   ]    |
           + [   ]<--/
          ----------
            (     ) = k

int HashCode(Long k){
    int lower = (int)k;
    int upper = k >> 32
    return lower + upper
}

    Really Long Obj ->
    000000000000000000000000000000000000 -> 32 bits long
    ++++++      -   -   -   -   -   ++++ -> size of an int

Polynomial
- when key is made up of Groups of bites + order maters -> use polynomial Hash Function





*/        