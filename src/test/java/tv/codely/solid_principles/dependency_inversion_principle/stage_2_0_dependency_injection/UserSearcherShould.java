package tv.codely.solid_principles.dependency_inversion_principle.stage_2_0_dependency_injection;

import org.junit.jupiter.api.Test;
import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UserSearcherShould {
    @Test
    void find_existing_users() {
        // Now we're injecting the HardcodedInMemoryUsersRepository instance through the UserSearcher constructor.
        // 👍 Win: We've moved away from the UserSearcher the instantiation logic of the HardcodedInMemoryUsersRepository class allowing us to centralize it.
        // 👍 Win: We're exposing the couplings of the UserSearcher class.
        HardcodedInMemoryUsersRepository usersRepository = new HardcodedInMemoryUsersRepository();
        UserSearcher userSearcher = new UserSearcher(usersRepository);

        Integer existingUserId = 1;
        Optional<User> expectedUser = Optional.of(new User(1, "Rafa"));

        assertEquals(expectedUser, userSearcher.search(existingUserId));
    }

    @Test
    void not_find_non_existing_users() {
        HardcodedInMemoryUsersRepository usersRepository = new HardcodedInMemoryUsersRepository();
        UserSearcher userSearcher = new UserSearcher(usersRepository);

        Integer nonExistingUserId = 5;
        Optional<User> expectedEmptyResult = Optional.empty();

        assertEquals(expectedEmptyResult, userSearcher.search(nonExistingUserId));
    }
}
