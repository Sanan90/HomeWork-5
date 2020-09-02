public class Potok implements Runnable {
    private float[] arr;
    String name;

    public Potok(String name, float[] arr) {
        this.name = name;
        this.arr = arr;
    }

    float[] itog = new float[1000000];


    public float[] getArr() {
        return arr;
    }

    long a = System.currentTimeMillis();



    @Override
    public void run() {
        if (this.name.equals("arr1")) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) *
                        Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.arraycopy(arr, 0, itog, 0, arr.length);
        } else if (this.name.equals("arr2")) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + arr.length) / 5) *
                        Math.cos(0.2f + (i + arr.length) / 5) *
                        Math.cos(0.4f + (i + arr.length) / 2));
            }
            System.arraycopy(arr, 0, itog, arr.length, arr.length);

        }

        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);


    }
}