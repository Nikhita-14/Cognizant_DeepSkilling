public class Main {
    public static void main(String[] args) {
        ForecastingTool tool = new ForecastingTool();

        double initialInvestment = 1000.0;
        double annualGrowthRate = 0.05;
        int years = 10;

        System.out.println("--- Running Financial Forecast ---");
        System.out.println("Initial Value: $" + initialInvestment);
        System.out.println("Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Period: " + years + " years");

        double forecastedValue = tool.calculateFutureValue(initialInvestment, annualGrowthRate, years);

        System.out.println("\n--- Forecast Result ---");
        System.out.printf("Predicted Future Value: $%.2f%n", forecastedValue);
    }
}