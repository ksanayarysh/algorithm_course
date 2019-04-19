import java.util.Random;

public class my {
    public static void main(String[] args) {
        float n = 200;
        int balanced = 0;
        for(int i = 0; i < n; i++)
        {
            if(generateAndCheckIfBalanced())
                balanced++;
        }
        System.out.println(balanced);
        System.out.println(balanced / n);
    }

    static  boolean generateAndCheckIfBalanced()
    {
        Random rand = new Random();
        MyTreeMap m = new MyTreeMap();
        while (m.getDepth() != 6)
        {
            m.put(rand.nextInt(200) - 99, rand.nextInt(200) - 99);
        }
        return m.isBalanced();
    }
}
