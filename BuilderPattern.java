/**
What is the Builder Pattern?
The Builder Pattern is a creational design pattern used to construct a complex object step by step. 
It separates the construction of an object from its representation, allowing the same construction process to create different representations (or configurations) of an object.
The Builder Pattern is particularly useful when you need to create an object that has many parts or fields and you want to control the construction process in a step-by-step manner, ensuring that you don’t end up with an incomplete or inconsistent object.

When to Use the Builder Pattern?
When an object has many parameters or configurations that need to be set.
When you want to create objects that must follow a particular construction sequence or must be built in stages.
When the object you're building is complex and you want to avoid having a constructor with too many parameters (known as the telescoping constructor problem).
*/

class House {
    // Required fields
    private final String walls;
    private final String roof;

    // Optional fields
    private final int doors;
    private final int windows;
    private final String floorType;
    private final boolean garden;

    private House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.doors = builder.doors;
        this.windows = builder.windows;
        this.floorType = builder.floorType;
        this.garden = builder.garden;
    }

    @Override
    public String toString() {
        return "House [walls=" + walls + ", roof=" + roof + ", doors=" + doors + ", windows=" + windows
                + ", floorType=" + floorType + ", garden=" + garden + "]";
    }

    public static class HouseBuilder {
        // Required fields
        private final String walls;
        private final String roof;

        // Optional fields -- we can leave this as well but then default values will be either 0 or "" or false
        private int doors = 1;
        private int windows = 1;
        private String floorType = "Tiled";
        private boolean garden = false;


        public HouseBuilder(String walls, String roof) {
            this.walls = walls;
            this.roof = roof;
        }

        public HouseBuilder setDoors(int doors) {
            this.doors = doors;
            return this;
        }

        public HouseBuilder setWindows(int windows) {
            this.windows = windows;
            return this;
        }

        public HouseBuilder setFloorType(String floorType) {
            this.floorType = floorType;
            return this;
        }

        public HouseBuilder setGarden(boolean garden) {
            this.garden = garden;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
public class BuilderPattern {
    public static void main(String[] args) {

        House house1 = new House.HouseBuilder("Brick", "Gable")
                .setDoors(3)
                .setWindows(10)
                .setFloorType("Wooden")
                .setGarden(true)
                .build();
        System.out.println(house1);

        House house2 = new House.HouseBuilder("Wood", "Flat")
                .setDoors(2)
                .setWindows(6)
                .build();
        System.out.println(house2);

        House house3 = new House.HouseBuilder("Concrete", "Slanted")
                .build();
        System.out.println(house3);
    }
}
