import static org.junit.Assert.*;

import org.junit.Test;

public class zooTest {
    //Test case when animal is added successfully
@Test
public void addAnimalWhenZooIsNotFull() {
	Zoo zoo=new Zoo();
	zoo.addZone("Bird");
	assertTrue(zoo.addAnimal("SherKhan", "Lion", 120, 10));
	assertTrue(zoo.addAnimal("mithu", "Parrot", 0.250, 10));
	assertTrue(zoo.addAnimal("Sheru", "Lion", 120, 10));
}
//Test case when animal not added
@Test(expected = AssertionError.class)
public void addAnimalWhenZooIsFull() {
	Zoo zoo=new Zoo();
	zoo.addZone("Bird");
	zoo.addZone("Bird");
	zoo.addZone("Bird");
	zoo.addAnimal("SherKhan", "Lion", 120, 10);
}
//Test case to add cage when zone not full
@Test
public void addCageWhenZoneIsNotFull() {
	Zoo zoo=new Zoo();
	zoo.addZone("Bird");
	assertTrue(zoo.addCage("Parrot"));
}
//Test case when cage cannot be added in zone
@Test(expected = AssertionError.class)
public void addCageWhenZoneIsFull() {
	Zoo zoo=new Zoo();
	zoo.addZone("Bird");
	zoo.addCage("Parrot");
	zoo.addCage("Eagle");
}
//Test case to remove an animal with given name
@Test
public void removeAnimalTest(){
	Zoo zoo=new Zoo();
	zoo.addZone("Bird");
	zoo.addAnimal("SherKhan", "Lion", 120, 10);
	zoo.addAnimal("Sheru", "Lion", 120, 10);
	assertTrue(zoo.removeAnimal("SherKhan", "Lion"));
	assertFalse(zoo.removeAnimal("mithu", "Lion"));
	}
}
