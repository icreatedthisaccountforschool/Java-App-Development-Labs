package main.java.com.kovunov.cpan252.tekkenuserdashboard.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kovunov.cpan252.tekkenuserdashboard.model.TekkenUser;

@RestController
@RequestMapping("/api/userdashboard")
public class UserDashboardController {

    @GetMapping
    public List<TekkenUser> getUsers() {
        var usersStream = Stream.of(new TekkenUser("Bob", 10, 6, 1), new TekkenUser("Brad", 11, 5, 1),
                new TekkenUser("Joel", 13, 6, 3));
        return usersStream.sorted(Comparator.comparing(TekkenUser::getWins)).collect(Collectors.toList());

    }

}