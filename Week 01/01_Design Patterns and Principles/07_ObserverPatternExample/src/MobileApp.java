public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Mobile App [" + name + "] Notification: " + stockSymbol + " is now $" + price);
    }
}