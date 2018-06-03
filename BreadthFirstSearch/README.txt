Breadth First Search Implementation

Simple implementation of bfs algorithm. The graph in the main class should look like the one on the picture.

Since bfs is a level by level traversal of the graph the solution shoud be : 1 4 5 2 3 6 7.

Explanation of example in main function:

Our starting point wil be vertex 1, so we put vertex1 in a queue and we start looping until queue is empty.

step 1: we print and take out(poll) vertex1 from queue, get his neighbour list that contains 4,5 and since we haven't visited them yet we put them on a queue and set them as visited. (queue contains 4,5)
step 2: print and poll vertex4, get neighbour list (includes vertex2), add vertex2 to queue and set to visited. (queue contains 5,2)
step 3: print and poll vertex5, get neighbour list (includes vertex3 and vertex6), add vertex3 and vertex6 to queue and set them to visited. (queue contains 2, 3, 6)
step 4: print and poll vertex2, get neighbour list (empty). (queue contains  3, 6)
step 5: print and poll vertex3, get neighbour list (empty). (queue contains 6)
step 6: print and poll vertex6, get neighbour list (includes vertex7), add vertex7 to queue and set it to visited. (queue contains 7)
step 7: print and poll vertex7, get neighbour list (empty). (queue is empty and we stop looping).

