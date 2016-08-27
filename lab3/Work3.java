import java.io.*;
import java.util.*;
import static java.lang.Math.pow;

class Work3 {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("r = ");

        double R = Math.abs(Double.valueOf(reader.readLine()));
        Forma forma = new Forma(R);
        PriorityQueue<Dot> queue = formQueue();

        for (Dot sot : queue)
            if (!forma.pickDot(sot))
                System.out.println(sot.toString());
    }

    private static PriorityQueue<Dot> formQueue() {
        Comparator<Dot> comparator = new DotComparator();
        PriorityQueue<Dot> queue = new PriorityQueue<>(comparator);

        queue.add(new Dot(-2.5f, -2));
        queue.add(new Dot(1, -3));
        queue.add(new Dot(0, 0));
        queue.add(new Dot(4, -5));
        queue.add(new Dot(-3, 3));
        queue.add(new Dot(1, -2));
        queue.add(new Dot(5, 4));
        queue.add(new Dot(-3, 4));

        return queue;
    }
}

class Dot {
    public float x = 0;
    public float y = 0;

    public Dot(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class DotComparator implements Comparator<Dot> {
    @Override
    public int compare(Dot o1, Dot o2) {
        if (Math.abs(o1.x*o1.y) < Math.abs(o2.x*o2.y))
            return -1;
        if (Math.abs(o1.x*o1.y) > Math.abs(o2.x*o2.y))
            return 1;
        return 0;
    }
}

class Forma {
    private double r = 0;

    public Forma(double r) {
        this.r = r;
    }

    public boolean pickDot(Dot dot) {
        if (dot.y > 0)
            return  dot.x >= 0 && dot.x <= r /2 && dot.y >= 0 && dot.y <= -2*dot.x + r;
        else
            return (dot.x >= -r /2 && dot.x <= 0 && dot.y >= -r && dot.y <= 0)
                    || (dot.x > 0 && dot.x <= r && dot.y <= 0 && Math.abs(dot.y) <= Math.sqrt(pow(r, 2) - pow(dot.x, 2)));
    }
}