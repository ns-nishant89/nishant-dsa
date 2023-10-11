class Solution {
    public int findTheCity(int numCities, int[][] cityConnections, int maxDistance) {
        
        // Initialize a 2D array to store distances between cities.
        int distances[][] = new int[numCities][numCities];
        int numConnections = cityConnections.length;

        // Initialize distances with a maximum value to represent infinity.
        for(int i = 0; i < numCities; i++){
            for(int j = 0; j < numCities; j++){
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        // Populate the distances array with the given connections.
        for(int i = 0; i < numConnections; i++){
            int cityA = cityConnections[i][0];
            int cityB = cityConnections[i][1];
            int distance = cityConnections[i][2];

            distances[cityA][cityB] = distance;
            distances[cityB][cityA] = distance;
        }

        // Set the distance from a city to itself as 0.
        for(int i = 0; i < numCities; i++){
            distances[i][i] = 0;
        }

        // Use the Floyd-Warshall algorithm to find the shortest distances between all pairs of cities.
        for(int k = 0; k < numCities; k++){
            for(int i = 0; i< numCities; i++){
                for(int j = 0; j < numCities; j++){
                    if(distances[i][k] == Integer.MAX_VALUE || distances[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        // Initialize variables to keep track of the city with the least number of reachable cities.
        int minReachableCities = numCities;
        int cityWithMinReachable = -1;

        // Iterate through each city and count how many cities are reachable within the given maximum distance.
        for(int city = 0; city < numCities; city++){
            int reachableCount = 0;
            for(int adjacentCity = 0; adjacentCity < numCities; adjacentCity++){
                if(distances[city][adjacentCity] <= maxDistance){
                    reachableCount++;
                }
            }
            // If the current city has fewer reachable cities, update the variables.
            if(reachableCount <= minReachableCities){
                minReachableCities = reachableCount;
                cityWithMinReachable = city;
            }
        }
        // Return the city with the least number of reachable cities within the maximum distance.
        return cityWithMinReachable;       
    }
}