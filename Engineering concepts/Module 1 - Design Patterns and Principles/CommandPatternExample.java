// --------------------------------------------------
// Command Interface
// --------------------------------------------------
interface Command {

    void execute();
}

// --------------------------------------------------
// Receiver Class
// --------------------------------------------------
class Light {

    public void turnOn() {

        System.out.println(
                "Light is ON");
    }

    public void turnOff() {

        System.out.println(
                "Light is OFF");
    }
}

// --------------------------------------------------
// Concrete Command - Light ON
// --------------------------------------------------
class LightOnCommand
        implements Command {

    private Light light;

    public LightOnCommand(
            Light light) {

        this.light = light;
    }

    @Override
    public void execute() {

        light.turnOn();
    }
}

// --------------------------------------------------
// Concrete Command - Light OFF
// --------------------------------------------------
class LightOffCommand
        implements Command {

    private Light light;

    public LightOffCommand(
            Light light) {

        this.light = light;
    }

    @Override
    public void execute() {

        light.turnOff();
    }
}

// --------------------------------------------------
// Invoker Class
// --------------------------------------------------
class RemoteControl {

    private Command command;

    public void setCommand(
            Command command) {

        this.command = command;
    }

    public void pressButton() {

        if (command != null) {

            command.execute();
        }
        else {

            System.out.println(
                    "No Command Assigned.");
        }
    }
}

// --------------------------------------------------
// Main Test Class
// --------------------------------------------------
public class CommandPatternExample {

    public static void main(String[] args) {

        System.out.println(
                "===== Command Pattern Demo =====\n");

        // Receiver
        Light livingRoomLight =
                new Light();

        // Commands
        Command lightOn =
                new LightOnCommand(
                        livingRoomLight);

        Command lightOff =
                new LightOffCommand(
                        livingRoomLight);

        // Invoker
        RemoteControl remote =
                new RemoteControl();

        // Turn ON Light
        System.out.println(
                "Pressing ON Button:");

        remote.setCommand(lightOn);

        remote.pressButton();

        // Turn OFF Light
        System.out.println(
                "\nPressing OFF Button:");

        remote.setCommand(lightOff);

        remote.pressButton();
    }
}