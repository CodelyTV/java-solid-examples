package tv.codely.solid_principles.dependency_inversion_principle.stage_2_1_dependency_injection_of_constant_parameters;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Map;
import java.util.Optional;

final class HardcodedInMemoryUsersRepository {
    private Map<Integer, User> users;

    public HardcodedInMemoryUsersRepository(Map<Integer, User> users) {
        this.users = users;
    }

    public Optional<User> search(Integer id) {
        return Optional.ofNullable(users.get(id));
    }
}
