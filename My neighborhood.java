import org.code.neighborhood.Painter;
import java.util.Random;
import java.util.ArrayList;

public class MyNeighborhood {
    public static void main(String[] args) {
        Painter sigmaSigmaOnTheWall = new Painter(0, 0, "East", 64);
        String[][] gridSpace = new String[8][8];

        // --- 元の長いペイント処理（維持） ---
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        turnAround(sigmaSigmaOnTheWall);
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "green");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "yellow");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "blue");
        paintAndRecord(sigmaSigmaOnTheWall, gridSpace, "red");

        // --- 無限プロシージャル・ランダム移動 ---
        String[] colors = {"red", "blue", "yellow", "green"};
        Random rand = new Random();

        System.out.println("Entering infinite random movement loop...");
        
        while (true) {
            String randomColor = colors[rand.nextInt(colors.length)];
            int randomRow = rand.nextInt(6); // 0-5行目
            
            // 行と色から、さらにランダムな列(Col)を抽出して移動
            findAndMoveRandomly(sigmaSigmaOnTheWall, gridSpace, randomColor, randomRow, rand);
        }
    }

    public static void findAndMoveRandomly(Painter p, String[][] grid, String targetColor, int targetRow, Random rand) {
        ArrayList<Integer> possibleCols = new ArrayList<>();
        for (int j = 0; j < grid[targetRow].length; j++) {
            if (targetColor.equals(grid[targetRow][j])) {
                possibleCols.add(j);
            }
        }

        if (!possibleCols.isEmpty()) {
            int targetCol = possibleCols.get(rand.nextInt(possibleCols.size()));

            // Y軸の移動
            while (p.getY() < targetRow) {
                while (!p.isFacingSouth()) p.turnLeft();
                if (p.canMove()) p.move();
            }
            while (p.getY() > targetRow) {
                while (!p.isFacingNorth()) p.turnLeft();
                if (p.canMove()) p.move();
            }

            // X軸の移動
            while (p.getX() < targetCol) {
                while (!p.isFacingEast()) p.turnLeft();
                if (p.canMove()) p.move();
            }
            while (p.getX() > targetCol) {
                while (!p.isFacingWest()) p.turnLeft();
                if (p.canMove()) p.move();
            }
            System.out.println("Infinite Move: [" + targetRow + "][" + targetCol + "] - " + targetColor);
        }
    }

    public static void paintAndRecord(Painter p, String[][] grid, String color) {
        p.paint(color);
        grid[p.getY()][p.getX()] = color; 
        if (p.canMove()) p.move();
    }

    public static void turnAround(Painter p) {
        p.turnLeft();
        p.turnLeft();
        while (p.canMove()) p.move();
        p.turnLeft();
        p.move();
        p.turnLeft();
    }
}
