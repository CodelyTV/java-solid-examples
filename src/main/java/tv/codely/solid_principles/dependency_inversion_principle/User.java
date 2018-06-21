package tv.codely.solid_principles.dependency_inversion_principle;

import java.util.Objects;

final public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;

        if (!(other instanceof User)) return false;

        User otherUser = (User) other;
        return Objects.equals(id, otherUser.id) && Objects.equals(name, otherUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
