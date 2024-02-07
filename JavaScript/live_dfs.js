/**
 * Function that performs depth-first search traversal.
 * @param graph A directed graph represented as an adjency matrix.
 * @param root The initial node to start the traversal
 */
function dfs(graph, root){
    // initializes relevant data structures
    	// a stack initialized with root node
    	// an output to be returned
    	// a set that tracks already visited node
    
    // iterate over each node to be visited
    
        // pop the node from the toVisit stack
        
        // check if node is visited
        
            // add node to the output
            // mark node as visited       
            // iterate over the children (in reverse order)
            
        
    
	// return the traversed nodes
    
}



// test case 1
graph = {"+": ["*",3], "*":[2,7], 2:[],7:[],3:[]};
root = "+" ;
output = dfs(graph, root);
console.log(output);


// test case 2
graph = {0: [1,3], 1:[2,3], 2:[3,1], 3:[0,1]};
root = 0 ;
output = dfs(graph, root);
console.log(output);
