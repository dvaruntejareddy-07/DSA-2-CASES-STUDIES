public class CivicEyeKnapsack {

    public static void main(String[] args) {

        String[] incidents = {
                "Accident",
                "Fire",
                "Traffic Jam",
                "Water Leakage",
                "Medical Emergency",
                "Power Failure",
                "Road Damage",
                "Gas Leakage"
        };

        int[] responseTime = {3, 5, 2, 4, 6, 3, 2, 5};
        int[] severity = {40, 70, 25, 35, 80, 30, 20, 60};

        int capacity = 15;
        int n = incidents.length;

        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP Table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {

                if (responseTime[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            dp[i - 1][w],
                            severity[i - 1]
                                    + dp[i - 1][w - responseTime[i - 1]]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("=== CivicEye Smart City Incident Monitoring ===");
        System.out.println("Maximum Severity Coverage = " + dp[n][capacity]);

        System.out.println("\nSelected Incidents:");

        int w = capacity;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {

                System.out.println(
                        incidents[i - 1]
                        + " (Response Time = "
                        + responseTime[i - 1]
                        + " hrs, Severity = "
                        + severity[i - 1] + ")"
                );

                w -= responseTime[i - 1];
            }
        }
    }
}