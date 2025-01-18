import java.util.*;

class Solution {
    private int maxX;
    private int minX;
    private int maxY;
    private int minY;
    private int width;
    private int height;

    public String[] solution(int[][] line) {
        Set<String> meets = new HashSet<>();
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            lines.add(new Line(line[i]));
        }
        minX = Integer.MAX_VALUE;
        maxX = Integer.MIN_VALUE;
        minY = Integer.MAX_VALUE;
        maxY = Integer.MIN_VALUE;

        for (int i = 0; i < lines.size(); i++) {
            for (int j = i + 1; j < lines.size(); j++) {
                int[] meet = getMeets(lines.get(i), lines.get(j));
                if (meet != null) {
                    int x = meet[0];
                    int y = meet[1];
                    meets.add(x + "," + y);
                    determineMinOrMaxWithX(x);
                    determineMinOrMaxWithY(y);
                }
            }
        }

        width = maxX - minX + 1;
        height = maxY - minY + 1;
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row, '.');
        }

        for (String meet : meets) {
            String[] coords = meet.split(",");
            int x = Integer.parseInt(coords[0]) - minX;
            int y = maxY - Integer.parseInt(coords[1]);
            arr[y][x] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(arr[i]);
        }
        return answer;
    }

    public int[] getMeets(Line line1, Line line2) {
        long a = line1.getA();
        long b = line1.getB();
        long e = line1.getC();
        long c = line2.getA();
        long d = line2.getB();
        long f = line2.getC();

        long denominator = a * d - b * c;
        if (denominator == 0) {
            return null;
        }

        long numeratorX = b * f - e * d;
        long numeratorY = e * c - a * f;

        if (numeratorX % denominator != 0 || numeratorY % denominator != 0) {
            return null;
        }

        int x = (int) (numeratorX / denominator);
        int y = (int) (numeratorY / denominator);

        return new int[]{x, y};
    }

    public void determineMinOrMaxWithX(int x) {
        if (minX > x) {
            minX = x;
        }
        if (maxX < x) {
            maxX = x;
        }
    }

    public void determineMinOrMaxWithY(int y) {
        if (minY > y) {
            minY = y;
        }
        if (maxY < y) {
            maxY = y;
        }
    }

    public static class Line {
        private long a;
        private long b;
        private long c;

        public Line(int[] line) {
            this.a = line[0];
            this.b = line[1];
            this.c = line[2];
        }

        public long getA() {
            return a;
        }

        public long getB() {
            return b;
        }

        public long getC() {
            return c;
        }
    }
}