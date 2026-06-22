public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();
        Light livingRoomLight = new Light();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        System.out.println("--- Testing Light On ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        System.out.println("\n--- Testing Light Off ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}