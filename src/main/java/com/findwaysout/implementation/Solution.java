package com.findwaysout.implementation;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    public String[][] convertTextFileToArray(Resource resource)throws IOException{

        InputStream inputStream = resource.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        int rowCount = 0;
        int columnCount = 0;
        String line;
        int biggest= 0;

        while ((line = reader.readLine()) != null) {
            String[] values = line.split("");

            if(biggest< values.length){
                biggest= values.length;
            }
            rowCount++;
        }
        columnCount= biggest;

        reader.close();
        InputStream inputStreamNew = resource.getInputStream();

        String[][] array = new String[rowCount][columnCount];

        reader = new BufferedReader(new InputStreamReader(inputStreamNew));

        int row = 0;
        while ((line = reader.readLine()) != null) {
            String[] values = line.split("");
            for (int column = 0; column < columnCount; column++) {
                if (column < values.length) {
                    array[row][column] = values[column];
                } else {
                    array[row][column] = " ";
                }
            }
            row++;
        }
        reader.close();

        return array;
    }
    private static boolean isExitPoint(String[][] map, int x, int y) {
        int rows = map.length;
        int cols = map[0].length;

        return x == 0 || y == 0 || x == rows - 1 || y == cols - 1;
    }
    private static boolean isSurroundedByOnes(String[][] map, int x, int y) {
        int rows = map.length;
        int cols = map[0].length;

        if (x > 0 && y > 0 && x < rows - 1 && y < cols - 1) {
            return map[x - 1][y].equals("1") && map[x + 1][y].equals("1") &&
                    map[x][y - 1].equals("1") && map[x][y + 1].equals("1");
        }
        return false;
    }

    public int countMinimumSteps (String filePath){
        List<Integer> numbersOfStepsForEachExit = new ArrayList<>();
        try{
            String[][] map = convertTextFileToArray(new ClassPathResource(filePath));
            int rows = map.length;
            int cols = map[0].length;

            int startX = -1;
            int startY = -1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (map[i][j].equals("X")) {
                        startX = i;
                        startY = j;
                        break;
                    }
                }
            }
            if (startX == -1) {
                return 0;
            }
            if(isSurroundedByOnes(map,startX,startY)){
                return 0;
            }
            Queue<int[]> queue = new ArrayDeque<>();
            Set<String> visited = new HashSet<>();

            queue.offer(new int[]{startX, startY, 0});
            visited.add(startX + "," + startY);

            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while(!queue.isEmpty()){
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int steps = current[2];

                if (isExitPoint(map, x, y)) {
                    numbersOfStepsForEachExit.add(steps);
                }

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited.contains(nx + "," + ny) &&
                            map[nx][ny].equals(" ")) {
                        visited.add(nx + "," + ny);
                        queue.offer(new int[]{nx, ny, steps + 1});
                    }
                }
            }
            Collections.sort(numbersOfStepsForEachExit);
        }catch (IOException e){
            e.printStackTrace();
        }
        if(numbersOfStepsForEachExit.size()>0){
            return numbersOfStepsForEachExit.get(0);
        }else {
            return 0;
        }
    }
}
