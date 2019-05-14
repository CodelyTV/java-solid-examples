package tv.codely.solid_principles.dependency_inversion_principle.stage_3_dependency_inversion;

import tv.codely.solid_principles.dependency_inversion_principle.User;

final class UserMother {
    static final int RAFA_ID = 1;
    static final int JAVI_ID = 2;

    private static final String RAFA_NAME = "Rafa";
    private static final String JAVI_NAME = "Javi";

    static User rafa() {
        return new User(RAFA_ID, RAFA_NAME);
    }

    static User javi() {
        return new User(JAVI_ID, JAVI_NAME);
    }
}
