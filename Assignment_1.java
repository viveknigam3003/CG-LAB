import java.util.*;

class Assignment_1 {

  /**
   * Prints the character 'N' of given size, using the character 'N' itself
   * 
   * @param size - Size of the letter to be displayed. Min Size = 3
   * 
   */
  static void printCharacter(int size) {
    for (int i = 0; i < size; ++i) {
      for (int j = 0; j < size; ++j) {
        if (j == 0 || j == size - 1 || i == j)
          System.out.print('N');
        else
          System.out.print(' ');
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Size: ");
    int size = sc.nextInt();

    if (size < 3) {
      System.out.println("Size should be greater than 2");
      System.exit(1);
    }
    printCharacter(size);

    sc.close();
  }
}