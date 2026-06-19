public class CO5 {

    static void countingSort(int[] priority) {

        int n = priority.length;

        int max = priority[0];
        for (int i = 1; i < n; i++) {
            if (priority[i] > max)
                max = priority[i];
        }

        int[] count = new int[max + 1];

        for (int i = 0; i < n; i++) {
            count[priority[i]]++;
        }

        int index = 0;

        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                priority[index++] = i;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {

        int[] incidentPriority = {4, 2, 5, 1, 3, 2, 1};

        countingSort(incidentPriority);

        System.out.println("====================================");
        System.out.println("CivicEye Smart City Incident System");
        System.out.println("Incident Priority Sorting");
        System.out.println("====================================");

        System.out.println("\nSorted Incident Priorities:");

        for (int p : incidentPriority) {
            System.out.print(p + " ");
        }
    }
}