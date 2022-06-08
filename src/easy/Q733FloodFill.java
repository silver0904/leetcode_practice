package easy;

public class Q733FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) return image;

        fill(image, sr, sc, originalColor, newColor);

        return image;
    }

    public static void fill(int[][] image, int sr, int sc, int color, int newColor){
        if ( sr < 0 || sr >= image.length || sc < 0 || sc >= image[sr].length || image[sr][sc] != color){
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr, sc-1, color, newColor);
        fill(image, sr, sc+1, color, newColor);
    }
}
