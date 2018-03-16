package seedu.address.model.util;

import static seedu.address.model.util.SampleDataUtil.getTagSet;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.pet.Pet;
import seedu.address.model.pet.PetAge;
import seedu.address.model.pet.PetGender;
import seedu.address.model.pet.PetName;
import seedu.address.model.pet.exceptions.DuplicatePetException;
import seedu.address.model.tag.Tag;

/**
 * Contains util for populating {@code AddressBook} with sampledata.
 */
public class SampleDataUtilPet {
    public static Pet[] getSamplePets() {
        return new Pet[] {
            new Pet(new PetName("Garfield"), new PetAge("5"), new PetGender("M"),
                    getTagSet("Cat", "tabby")),
            new Pet(new PetName("Scooby Doo"), new PetAge("10"), new PetGender("M"),
                    getTagSet("Dog", "great_dane"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        try {
            AddressBook sampleAb = new AddressBook();
            for (Pet samplePet : getSamplePets()) {
                sampleAb.addPet(samplePet);
            }
            return sampleAb;
        } catch (DuplicatePetException e) {
            throw new AssertionError("sample data cannot contain duplicate pets", e);
        }
    }

    /**
     * Returns a tag set containg list of strings given
     */
    public static Set<Tag> getTagSet(String... strings) {
        HashSet<Tag> tags = new HashSet<>();
        for (String s : strings) {
            tags.add(new Tag(s));
        }

        return tags;
    }
}
