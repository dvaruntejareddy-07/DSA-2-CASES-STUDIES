public class CO2 {

    static int rangeMin(int arr[], int l, int r) {
        int min = arr[l];

        for (int i = l; i <= r; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int severity[] = {8, 4, 6, 2, 9, 5};

        int result = rangeMin(severity, 1, 4);

        System.out.println("Minimum Severity = " + result);
    }
}