public class Main extends Thread{
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;


    public static void main(String[] args) {

        arrayTime1();

        arrayTo2sStreems();


    }


    public static void arrayTime1(){
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis());
    }

    public static void arrayTo2sStreems() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = 1;
        }
        float[] myArray1 = new float[HALF];
                System.arraycopy(arr, 0, myArray1, 0, HALF);
        float[] myArray2 = new float[HALF];
                System.arraycopy(arr, HALF, myArray2, 0, HALF);

                    Thread arr1Thred = new Thread(() -> {
                        for (int i = 0; i < HALF; i++) {
                            myArray1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                        }
                    });
                    Thread arr2Thred = new Thread(() -> {
                        for (int i = 0; i < HALF; i++) {
                            myArray2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                        }
                    });

                    arr1Thred.start();
                    arr2Thred.start();

                System.arraycopy(myArray1,0,arr,0,HALF);
                System.arraycopy(myArray2,0,arr,HALF,HALF);
        System.out.println(System.currentTimeMillis());





    }

}
