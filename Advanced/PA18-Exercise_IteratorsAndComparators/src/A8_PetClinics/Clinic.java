package A8_PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Clinic {

    private String name;
    private int rooms;
    private int emptyRoomsCounter;
    private final int centerRoom;
    private Map<Integer, Pet> data;

    public Clinic(String name, int rooms) {
        this.name = name;
        checkRoomsCount(rooms);
        this.emptyRoomsCounter = rooms;
        this.data = new HashMap<>();
        for (int i = 1; i <= rooms; i++) {
            data.put(i, null);
        }
        this.centerRoom = rooms / 2 + 1;
    }

    private void checkRoomsCount(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public boolean add(Pet pet) {
        if (!hasEmptyRooms()) {
            return false;
        }
        for (int i = 0; i < this.centerRoom; i++) {
            if (data.get(this.centerRoom - i) == null) {
                data.put(this.centerRoom - i, pet);
                emptyRoomsCounter--;
                return true;
            } else if (data.get(this.centerRoom + i) == null) {
                data.put(this.centerRoom + i, pet);
                emptyRoomsCounter--;
                return true;
            }
        }
        return false;
    }

    public boolean release() {
        boolean isFromTheStart = false;
        for (int i = this.centerRoom; i <= rooms; i++) {
            if (data.get(i) != null) {
                data.put(i, null);
                emptyRoomsCounter++;
                return true;
            }
            if (i == rooms && !isFromTheStart) {
                i = 0;
                isFromTheStart = true;
            }
        }
        return false;
    }

    public boolean hasEmptyRooms() {
        return emptyRoomsCounter > 0;
    }

    public void printAllRooms() {
        data.forEach((key, value) -> {
            if (value != null) {
                System.out.println(value);
            } else {
                System.out.println("Room empty");
            }
        });
    }

    public void printRoom(int room) {
        data.entrySet()
                .stream()
                .filter(e -> e.getKey() == room)
                .forEach(e -> {
                    if (e.getValue() != null) {
                        System.out.println(e.getValue());
                    } else {
                        System.out.println("Room empty");
                    }
                });
    }
}
