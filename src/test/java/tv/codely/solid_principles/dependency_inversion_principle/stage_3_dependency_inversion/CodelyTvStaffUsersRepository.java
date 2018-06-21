package tv.codely.solid_principles.dependency_inversion_principle.stage_3_dependency_inversion;

import tv.codely.solid_principles.dependency_inversion_principle.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// ℹ️ User repository for test usage. It is used as a _Test double_, more specifically, it's a _Stub_.
// More info on the difference between Stubs and Mocks: https://martinfowler.com/articles/mocksArentStubs.html
final class CodelyTvStaffUsersRepository implements UsersRepository {
    private Map<Integer, User> users = Collections.unmodifiableMap(new HashMap<Integer, User>() {
        {
            put(UserStub.RAFA_ID, UserStub.rafa());
            put(UserStub.JAVI_ID, UserStub.javi());
        }
    });

    @Override
    public Optional<User> search(Integer id) {
        return Optional.ofNullable(users.get(id));
    }
}

