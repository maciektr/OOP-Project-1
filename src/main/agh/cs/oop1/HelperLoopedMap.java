package agh.cs.oop1;

class HelperLoopedMap {
    static boolean checkIfInputIsLegal(int mapSideA, int mapSideB, int jungleSideA, int jungleSideB){
        if(mapSideA <= 0 || mapSideB <= 0 || jungleSideA < 0 || jungleSideB < 0)
            throw new IllegalArgumentException("Map size can not be negative!");
        if(mapSideA < jungleSideA || mapSideB < jungleSideB)
            throw new IllegalArgumentException("Map size can not be less than jungle size!");
        if(mapSideA == jungleSideA || mapSideB == jungleSideB)
            throw new IllegalArgumentException("Map size can not be equal to jungle size!");
        return true;
    }

    static Vector2d getUpperRight(Vector2d mapLowerLeft, int mapSideA, int mapSideB){
        return mapLowerLeft.add(new Vector2d(mapSideA,mapSideB));
    }

    static boolean checkIfInputIsLegal(Vector2d mapLowerLeft, Vector2d mapUpperRight, Vector2d jungleLowerLeft, Vector2d jungleUpperRight){
        if(jungleLowerLeft.equals(mapLowerLeft))
            throw new IllegalArgumentException("Map lower left and jungle lower left are equal!");

        if(!jungleLowerLeft.lowerLeft(mapLowerLeft).equals(mapLowerLeft))
            throw new IllegalArgumentException("Map lower left is not a lower left of jungle!");
        if(!mapUpperRight.upperRight(mapLowerLeft).equals(mapUpperRight))
            throw new IllegalArgumentException("Specified map sides sizes are incorrect!");

        if(!mapUpperRight.upperRight(jungleLowerLeft).equals(mapUpperRight)  || !mapUpperRight.upperRight(jungleUpperRight).equals(mapUpperRight))
            throw new IllegalArgumentException("Jungle location / size is incorrect!");

        return true;
    }

    static boolean checkIfInputIsLegal(Vector2d mapLowerLeft, Vector2d jungleLowerLeft, int mapSideA, int mapSideB, int jungleSideA, int jungleSideB){
        checkIfInputIsLegal(mapSideA,mapSideB,jungleSideA,jungleSideB);

        final Vector2d mapUpperRight = getUpperRight(mapLowerLeft,mapSideA,mapSideB);
        final Vector2d jungleUpperRight = getUpperRight(jungleLowerLeft, jungleSideA,jungleSideB);

        checkIfInputIsLegal(mapLowerLeft, mapUpperRight, jungleLowerLeft, jungleUpperRight);
        return true;
    }


}
