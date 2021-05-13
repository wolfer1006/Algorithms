class Solution {
    enum Direction{
        NORTH,
        EAST,
        SOUTH,
        WEST
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int yAxis = 0;
        int xAxis = 0;
        int maxEucl = 0;
        Direction direction = Direction.NORTH;
        
        //Make a set for the obstacles
        Set<String> obstacleSet = new HashSet<String>();
        for(int i = 0; i < obstacles.length; i++){
            String key = obstacles[i][0] + " " + obstacles[i][1];
            obstacleSet.add(key);
        }
        
        for(int command: commands){
            switch(command){
                case -2:
                    switch(direction){
                        case NORTH:
                            direction = Direction.WEST;
                            break;
                        case WEST:
                            direction = Direction.SOUTH;
                            break;
                        case SOUTH:
                            direction = Direction.EAST;
                            break;
                        default:
                            direction = Direction.NORTH;
                    }
                    break;
                case -1:
                    switch(direction){
                        case NORTH:
                            direction = Direction.EAST;
                            break;
                        case EAST:
                            direction = Direction.SOUTH;
                            break;
                        case SOUTH:
                            direction = Direction.WEST;
                            break;
                        default:
                            direction = Direction.NORTH;
                    }
                    break;
                default:
                    // System.out.println("Direction: " + direction + " dist: " + command + " xAxis: " + xAxis + " yAxis " + yAxis);
                    switch(direction){
                        case NORTH:
                            for(int i = 1; i <= command; i++){
                                if(noObstacle(xAxis, yAxis + 1, obstacleSet)){
                                    yAxis += 1;
                                }
                                else
                                    break;
                            }
                            // yAxis += command;
                            break; 
                        case SOUTH:
                            for(int i = 1; i <= command; i++){
                                if(noObstacle(xAxis, yAxis - 1, obstacleSet)){
                                    yAxis -= 1;
                                }
                                else
                                    break;
                            }
                            // yAxis -= command;
                            break;
                        case EAST:
                            for(int i = 1; i <= command; i++){
                                if(noObstacle(xAxis + 1, yAxis, obstacleSet)){
                                    xAxis += 1;
                                }
                                else
                                    break;
                            }
                            // xAxis += command;
                            break;
                        default:
                            for(int i = 1; i <= command; i++){
                                if(noObstacle(xAxis - 1, yAxis, obstacleSet)){
                                    xAxis -= 1;
                                }
                                else
                                    break;
                            }
                            // xAxis -= command;   
                    }
            }
            int currentEucl = xAxis * xAxis + yAxis * yAxis;
            if(currentEucl > maxEucl){
                maxEucl = currentEucl;
            }
        }
        System.out.println(xAxis);
        System.out.println(yAxis);
        return maxEucl;
    }
    
    public boolean noObstacle(int xAxis, int yAxis, Set<String> obstacleSet){
            String space = xAxis + " " + yAxis;
            if(obstacleSet.contains(space)){
                // System.out.println("Obstacle reached");
                return false;
            }
        return true;
    }
}