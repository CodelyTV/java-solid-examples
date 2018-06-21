package tv.codely.solid_principles.dependency_inversion_principle.stage_2_1_dependency_injection_of_constant_parameters;

import org.junit.jupiter.api.Test;
import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UserSearcherShould {
    @Test
    void find_existing_users() {
        // Now we're also injecting the constant parameters needed by the HardcodedInMemoryUsersRepository through its constructor.
        // 👍 Win: We can send different parameters depending on the environment.
        // That is, in our production environment we would have actual users,
        // while in our tests cases we will set only the needed ones to run our test cases
        int rafaId = 1;
        User rafa = new User(rafaId, "Rafa");

        Map<Integer, User> users = Collections.unmodifiableMap(new HashMap<Integer, User>() {
            {
                put(rafaId, rafa);
            }
        });
        HardcodedInMemoryUsersRepository usersRepository = new HardcodedInMemoryUsersRepository(users);
        UserSearcher userSearcher = new UserSearcher(usersRepository);

        Optional<User> expectedUser = Optional.of(rafa);

        assertEquals(expectedUser, userSearcher.search(rafaId));
    }

    @Test
    void not_find_non_existing_users() {
        Map<Integer, User> users = Collections.emptyMap();
        HardcodedInMemoryUsersRepository usersRepository = new HardcodedInMemoryUsersRepository(users);
        UserSearcher userSearcher = new UserSearcher(usersRepository);

        // 👍 Win: Now we don't have to be coupled of the actual HardcodedInMemoryUsersRepository users.
        // We can send a random user ID in order to force an empty result because we've set an empty map as the system users.
        Integer nonExistingUserId = 1;
        Optional<User> expectedEmptyResult = Optional.empty();

        assertEquals(expectedEmptyResult, userSearcher.search(nonExistingUserId));
    }
}
