package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @RequestMapping("/")
    public String index(Model model){
//        first lets create an actor.
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

//        Now let's create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis.....");

//        Add a movie to an empty list
        Set<Movie> movies = new HashSet<Movies>();
        movie.add(movie);

//        Add a list of movies to the actor's movie list
        actor.setMovies(movies);

//        save the actor to database
        actorRepository.save(actor);

//        grab all the actorsfrom database and send them to
//        the template
        model.addAttribute("actor", actorRepository.findAll());
        return "index"
    }
}
