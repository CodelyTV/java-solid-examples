package tv.codely.solid_principles.dependency_inversion_principle.stage_1_instantiating_from_clients;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

final class UserSearcher {
    private HardcodedInMemoryUsersRepository usersRepository =
        new HardcodedInMemoryUsersRepository();

    public Optional<User> search(Integer id) {
        return usersRepository.search(id);
    }
}
