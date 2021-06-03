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
   */
  static char[][] reflectY(char canvas[][]) {
    int size = canvas.length;
    char[][] reflectedCanvas = new char[size][size];
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        reflectedCanvas[i][j] = canvas[i][size - 1 - j];
      }
    }

    return reflectedCanvas;
  }

  /*
   * Reflects a canvas along X axis
   * 
   * @param canvas - A double dimension square character array
   */
  static char[][] reflectX(char canvas[][]) {
    int size = canvas.length;
    char[][] reflectedCanvas = new char[size][size];
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        reflectedCanvas[i][j] = canvas[size - 1 - i][j];
      }
    }

    return reflectedCanvas;
  }

  /*
   * Prints a square canvas
   * 
   * @param canvas - A double dimension square character array
   */
  static void printCanvas(char[][] canvas) {
    for (int i = 0; i < canvas.length; ++i) {
      for (int j = 0; j < canvas.length; ++j) {
        System.out.print(canvas[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Size: ");
    int size = sc.nextInt();

    if (size < 3) {
      System.out.println("Size should be greater than 2");
      System.exit(1);
    }

    System.out.println("Original Character:");
    printCanvas(generateCanvas(size));

    System.out.println("Reflection along X axis:");
    printCanvas(reflectX(generateCanvas(size)));

    System.out.println("Reflection along Y axis:");
    printCanvas(reflectY(generateCanvas(size)));

    sc.close();
  }
}