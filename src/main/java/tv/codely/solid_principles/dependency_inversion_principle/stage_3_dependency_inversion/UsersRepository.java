package tv.codely.solid_principles.dependency_inversion_principle.stage_3_dependency_inversion;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

public interface UsersRepository {
    Optional<User> search(Integer id);
}
