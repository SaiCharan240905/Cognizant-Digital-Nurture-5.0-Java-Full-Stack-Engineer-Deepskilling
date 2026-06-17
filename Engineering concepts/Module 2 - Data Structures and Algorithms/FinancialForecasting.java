import java.text.DecimalFormat;

public class FinancialForecasting {

    // Recursive Method
    public static double predictFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Case
        return predictFutureValue(
                currentValue,
                growthRate,
                years - 1)
                * (1 + growthRate);
    }

    // Display yearly forecast recursively
    public static void displayYearlyForecast(
            double currentValue,
            double growthRate,
            int currentYear,
            int totalYears) {

        if (currentYear > totalYears) {
            return;
        }

        double value =
                predictFutureValue(
                        currentValue,
                        growthRate,
                        currentYear);

        System.out.println(
                "Year " + currentYear +
                " : ₹" +
                new DecimalFormat("0.00")
                        .format(value));

        displayYearlyForecast(
                currentValue,
                growthRate,
                currentYear + 1,
                totalYears);
    }

    public static void main(String[] args) {

        double initialInvestment = 10000;
        double growthRate = 0.10; // 10%
        int forecastYears = 5;

        System.out.println(
                "========== FINANCIAL FORECASTING ==========\n");

        System.out.println(
                "Initial Investment : ₹"
                        + initialInvestment);

        System.out.println(
                "Annual Growth Rate : "
                        + (growthRate * 100)
                        + "%");

        System.out.println(
                "Forecast Period : "
                        + forecastYears
                        + " Years\n");

        System.out.println(
                "Year-wise Forecast:\n");

        displayYearlyForecast(
                initialInvestment,
                growthRate,
                0,
                forecastYears);

        double futureValue =
                predictFutureValue(
                        initialInvestment,
                        growthRate,
                        forecastYears);

        System.out.println(
                "\nPredicted Future Value after "
                        + forecastYears
                        + " years = ₹"
                        + new DecimalFormat("0.00")
                        .format(futureValue));
    }
}