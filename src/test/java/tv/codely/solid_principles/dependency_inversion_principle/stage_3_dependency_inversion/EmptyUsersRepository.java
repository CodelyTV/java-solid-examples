package tv.codely.solid_principles.dependency_inversion_principle.stage_3_dependency_inversion;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Optional;

// ℹ️ User repository for test usage. It is used as a _Test double_, more specifically, it's a _Fake_.
// More info on the main types of Test doubles: https://testing.googleblog.com/2013/07/testing-on-toilet-know-your-test-doubles.html
final class EmptyUsersRepository implements UsersRepository {
    @Override
    public Optional<User> search(Integer id) {
        return Optional.empty();
    }
}
