package hello;

public class ClosestPoint {

    public static void main(String[] args) {
        final int x = 0;
        final int y = 1;

        double [] coordinate = {4, 2};
        double [][][] points = {{{-1, 2}, {3, 4}}, {{-3, 5}, {10, 5}}, {{3, 3}, {5, 5}}};

        double[][] closest = nearestPoint(coordinate, points);
        System.out.println("(" + closest[0][x] + ", " +  closest[0][y] + ")" + "," + " (" + closest[1][x] + ", " +  closest[1][y] +")");
        double d = distance(coordinate[x], coordinate[y], closest[0][x], closest[0][y]) + distance(coordinate[x], coordinate[y], closest[1][x], closest[1][y]);
        System.out.println("Distance:" + d);

    }


    public static double distance (double x1, double y1, double x2, double y2) {
        double x = Math.pow(x2-x1, 2);
        double y = Math.pow(y2-y1, 2);
        return Math.sqrt(x+y);
    }

     public static double[][] nearestPoint (double[] coordinate, double[][][] points) {

        final int x = 0;
        final int y = 1;
        double[][] closestPoint = points[0];
        double closestDist = distance(coordinate[x], coordinate[y], closestPoint[0][x], closestPoint[0][y]) + distance(coordinate[x], coordinate[y], closestPoint[1][x], closestPoint[1][y]);
        for(int i = 0; i < points.length; i++) {
            double dist = distance(coordinate[x], coordinate[y], points[i][0][x], points[i][0][y] + distance(coordinate[x], coordinate[y], points[i][1][x], points[i][1][y]));
            //System.out.println(dist);
            if (dist < closestDist) {
                closestDist = dist;
                closestPoint = points[i];
            }
        }

        return closestPoint;

    }
}