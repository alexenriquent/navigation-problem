# Navigation Problem

### Input format
The input is two .txt files: One file contains the environment map, while another file contains the queries.

* **The environment map** is represented as a graph. This graph is written in a matrix format: The matrix’ size is nXn, where n is the number of vertices in the graph. Element [i, j] (row-i, col-j) of the matrix is the cost of moving from vertex-i to vertex-j. The cost of an edge is always a real number greater than 0.01. An element, say [i, j], with value 0 means there is no edge from vertex-i to vertex-j.
The file that contains this graph consists of n+1 lines. The first line contains only a single number: n. Each of the next n lines correspond to each row in the matrix, with line-k in the file corresponding to row-(k-1) in the matrix. The rows are separated by a single white space.
* **The queries file** contains q+1 lines, where q is the number of queries. The first line contains only a single number: q. The rest of the files are the queries.
Each query is written in a single line, and consists of three components separated by a single white space. The first component is the type of algorithm to use. In this assignment, there will only be 2 types of algorithms: Uniform for Uniform Cost search and A* for A* search. The second component is the ID of the initial vertex, while the third component is the ID of the goal vertex.

### Output format
* **The output file** contains q lines, where q is the number of queries in the input file. Each solution (the shortest path) is written in a single line. The solution at line q must be the solution of the query at line q+1 in the input file. Each path should be written as a sequence of vertices separated by a dash (“-“) sign. This sequence starts with the initial vertex and ends with the goal vertex.
