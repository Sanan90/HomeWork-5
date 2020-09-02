import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Main {
    static final int size = 1000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }


        long a = System.currentTimeMillis();

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);



        Thread arr11 = new Thread(new Potok("arr1", arr1));
        Thread arr22 = new Thread(new Potok("arr2", arr2));

        arr11.start();
        arr22.start();




        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i) / 5) *
                    Math.cos(0.2f + (i) / 5) * Math.cos(0.4f +
                    (i) / 2));
        }
        System.currentTimeMillis();
        System.out.println(System.currentTimeMillis() - a);
    }
}
