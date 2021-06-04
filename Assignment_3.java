import java.util.HashMap;

class Assignment_3 {

  static HashMap<Integer, Integer> generateGraphValues(int amplitude, int timePeriod, int limitX) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int x = 0, y = 0; x < limitX; x++) {
      y = (int) Math.abs((Math.round(amplitude * Math.sin(x / (timePeriod * 3.14)))) - amplitude);
      map.put(x, y);
    }

    return map;
  }

  static char[][] generateCanvas(HashMap<Integer, Integer> values, int amplitude) {
    char[][] canvas = new char[2 * amplitude + 1][values.size() + 1];

    for (int x : values.keySet()) {
      int y = values.get(x);
      canvas[y][x] = '*';
    }

    return canvas;
  }

  static void printCanvas(char[][] canvas) {
    int height = canvas.length;
    int width = canvas[1].length;
    int mid = (height - 1)/2;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        //Labeling the axes
        if(i == 0 && j == 0){
          System.out.print('Y');
          continue;
        }

        if(i == mid && j == width - 1){
          System.out.print('X');
          continue;
        }


        // Printing Canvas
        if (canvas[i][j] != '*') {

          // Printing Axis/Space
          if (i == mid || j == 0)
            System.out.print('#');
          else
            System.out.print(' ');
        } else {
          System.out.print(canvas[i][j]);
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int AMPLITUDE = 10;
    int TIME_PERIOD = 5;
    int LIMIT_X = 101;

    HashMap<Integer, Integer> graphValues = generateGraphValues(AMPLITUDE, TIME_PERIOD, LIMIT_X);
    char[][] canvas = generateCanvas(graphValues, AMPLITUDE);
    printCanvas(canvas);
  }
}