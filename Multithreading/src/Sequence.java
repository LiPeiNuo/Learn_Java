public class Sequence {
    public static void main(String[] args) {
        for(int i = 0; i<10; i++){
            final int j = i;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
