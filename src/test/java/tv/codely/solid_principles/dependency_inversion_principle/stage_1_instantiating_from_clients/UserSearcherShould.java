package tv.codely.solid_principles.dependency_inversion_principle.stage_1_instantiating_from_clients;

import org.junit.jupiter.api.Test;
import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UserSearcherShould {
    @Test
    void find_existing_users() {
        UserSearcher userSearcher = new UserSearcher();

        // We would be coupled to the actual HardcodedInMemoryUsersRepository implementation.
        // We don't have the option to set test users as we would have to do if we had a real database repository.
        Integer existingUserId = 1;
        Optional<User> expectedUser = Optional.of(new User(1, "Rafa"));

        assertEquals(expectedUser, userSearcher.search(existingUserId));
    }

    @Test
    void not_find_non_existing_users() {
        UserSearcher userSearcher = new UserSearcher();

        Integer nonExistingUserId = 5;
        Optional<User> expectedEmptyResult = Optional.empty();

        assertEquals(expectedEmptyResult, userSearcher.search(nonExistingUserId));
    }
}
