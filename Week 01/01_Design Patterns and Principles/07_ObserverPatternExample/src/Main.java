public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileClient = new MobileApp("iPhone User");
        Observer webClient = new WebApp("Enterprise Dashboard");

        stockMarket.registerObserver(mobileClient);
        stockMarket.registerObserver(webClient);

        System.out.println("--- First Price Update ---");
        stockMarket.setStockData("AAPL", 175.50);

        System.out.println("\n--- Second Price Update ---");
        stockMarket.setStockData("GOOGL", 2800.25);

        System.out.println("\n--- Removing Web Client and Updating Price ---");
        stockMarket.deregisterObserver(webClient);
        stockMarket.setStockData("MSFT", 330.10);
    }
}