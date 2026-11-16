package io.student.rangiffler.test.profile;

import io.student.rangiffler.jupiter.annotation.User;
import io.student.rangiffler.model.TestUser;
import io.student.rangiffler.ui.page.LoginPage;
import io.student.rangiffler.ui.page.ProfilePage;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Selenide;

public class CountryChangeTest {

  @Test
  @User
  void shouldChangeCountryToGermany(TestUser user) {
    ProfilePage profile = Selenide.open(LoginPage.URL, LoginPage.class)
        .login(user.username(), user.password())
        .openProfile();
    profile.selectCountry("Germany").clickSave().reload();
    profile.checkThatLocation("Germany");
  }
}
