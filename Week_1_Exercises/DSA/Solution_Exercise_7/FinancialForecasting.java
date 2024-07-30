public class FinancialForecasting {

    // Recursive function to predict future value
    public static double recursiveForecast(double currentValue, double growthRate, int steps) {
        if (steps == 0) {
            return currentValue; // Base case: Return the last observed value
        } else {
            // Recursive case: Forecast next value based on growth rate
            double nextValue = currentValue * (1 + growthRate);
            return recursiveForecast(nextValue, growthRate, steps - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage:
        double initialPrice = 100.0; // Initial stock price
        double averageGrowthRate = 0.05; // Assume 5% average growth rate
        int forecastSteps = 3; // Forecast 3 steps into the future

        double forecastedValue = recursiveForecast(initialPrice, averageGrowthRate, forecastSteps);
        System.out.printf("Forecasted value: %.2f%n", forecastedValue);
    }
}
