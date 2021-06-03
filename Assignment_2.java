import java.util.*;

class Assignment_2 {
  /**
   * Prints the character 'N' of given size, using the character 'N' itself
   * 
   * @param size - Size of the letter to be displayed. Min Size = 3
   * 
   */
  static char[][] generateCanvas(int size) {
    char[][] canvas = new char[size][size];

    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        if (j == 0 || j == size - 1 || i == j)
          canvas[i][j] = 'N';
        else
          canvas[i][j] = ' ';
      }
    }

    return canvas;
  }

  /*
   * Reflects a canvas along Y axis
   * 
   * @param canvas - A double dimension square character array
   * 
   * @param d - Integer distance between the characters
   */
  static void reflectY(char canvas[][], int d) {
    int size = canvas.length;

    int width = 2 * size + 1 + 2 * d;
    int height = size;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        // Printing the original character 'N'
        if (j < size) {
          System.out.print(canvas[i][j]);
        }

        // Printing the separator with distance on either side
        if (j >= size && j < size + 2 * d + 1) {
          if (j == (size + d))
            System.out.print("|");
          else
            System.out.print(" ");
        }

        // Printing the reflected character
        if (j >= size + 2 * d + 1) {
          System.out.print(canvas[i][width - 1 - j]);
        }
      }
      System.out.println();
    }
  }

  /*
   * Reflects a canvas along X axis
   * 
   * @param canvas - A double dimension square character array
   */
  static void reflectX(char canvas[][], int d) {
    int size = canvas.length;

    int width = size;
    int height = 2 * size + 1 + 2 * d;;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {

        // Printing the original character 'N'
        if (i < size) {
          System.out.print(canvas[i][j]);
        }

        // Printing the separator with distance on either side
        if (i >= size && i < size + 2 * d + 1) {
          if (i == (size + d))
            System.out.print("-");
          else
            System.out.print(" ");
        }

        // Printing the reflected character
        if (i >= size + 2 * d + 1) {
          System.out.print(canvas[height - 1 - i][j]);
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Size: ");
    int size = sc.nextInt();

    System.out.print("Enter Distance: ");
    int distance = sc.nextInt();

    if (size < 3) {
      System.out.println("Size should be greater than 2");
      System.exit(1);
    }

    // System.out.println("Original Character:");
    // printCanvas(generateCanvas(size));

    // System.out.println("Reflection along X axis:");
    // printCanvas(reflectX(generateCanvas(size)));

    char[][] canvas = generateCanvas(size);

    System.out.println("Reflection along Y axis:");
    reflectY(canvas, distance);

    System.out.println("Reflection along X axis:");
    reflectX(canvas, distance);

    sc.close();
  }
}