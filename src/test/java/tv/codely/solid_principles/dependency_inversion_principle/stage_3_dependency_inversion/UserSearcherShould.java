package tv.codely.solid_principles.dependency_inversion_principle.stage_3_dependency_inversion;

import org.junit.jupiter.api.Test;
import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class UserSearcherShould {
    @Test
    void find_existing_users() {
        // Now we're injecting to the UserSearcher use case different implementation of the new UserRepository interface.
        // 👍 Win: We can replace the actual implementation of the UsersRepository used by the UserSearcher.
        // That is, we'll not have to modify a single line of the UserSearcher class despite of changing our whole infrastructure.
        // This is a big win in terms of being more tolerant to changes.
        // 👍 Win: It also make it easier for us to test the UserSearcher without using the actual implementation of the repository used in production.
        // This is another big win because this way we can have test such as the following ones which doesn't actually go to the database in order to retrieve the system users.
        // This has a huge impact in terms of the time to wait until all of our test suite is being executed (quicker feedback loop for developers 💪).
        // 👍 Win: We can reuse the test environment repository using test doubles. See CodelyTvStaffUsersRepository for its particularities
        UsersRepository codelyTvStaffUsersRepository = new CodelyTvStaffUsersRepository();
        UserSearcher userSearcher = new UserSearcher(codelyTvStaffUsersRepository);

        Optional<User> expectedUser = Optional.of(UserMother.rafa());

        assertEquals(expectedUser, userSearcher.search(UserMother.RAFA_ID));
    }

    @Test
    void not_find_non_existing_users() {
        // 👍 Win: Our test are far more readable because they doesn't have to deal with the internal implementation of the UserRepository.
        // The test is 100% focused on orchestrating the Arrange/Act/Assert or Given/When/Then flow.
        // More info: http://wiki.c2.com/?ArrangeActAssert and https://www.martinfowler.com/bliki/GivenWhenThen.html
        UsersRepository emptyUsersRepository = new EmptyUsersRepository();
        UserSearcher userSearcher = new UserSearcher(emptyUsersRepository);

        Integer nonExistingUserId = 1;
        Optional<User> expectedEmptyResult = Optional.empty();

        assertEquals(expectedEmptyResult, userSearcher.search(nonExistingUserId));
    }
}
