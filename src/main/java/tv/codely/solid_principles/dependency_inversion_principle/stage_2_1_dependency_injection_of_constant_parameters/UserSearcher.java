package tv.codely.solid_principles.dependency_inversion_principle.stage_2_1_dependency_injection_of_constant_parameters;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

final class UserSearcher {
    private HardcodedInMemoryUsersRepository usersRepository;

    public UserSearcher(HardcodedInMemoryUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<User> search(Integer id) {
        return usersRepository.search(id);
    }
}
