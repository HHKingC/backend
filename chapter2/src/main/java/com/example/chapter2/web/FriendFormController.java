package com.example.chapter2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.chapter2.domain.Friend;

@Controller
public class FriendFormController {

    private final List<Friend> friends = new ArrayList<>();

    // GET: form and list on the same page: http://localhost:8080/friends
    @GetMapping("/friends")
    public String showPage(Model model) {
        model.addAttribute("friend", new Friend());
        model.addAttribute("friends", friends);
        return "friends";
    }

    // POST: save and reload the same page
    @PostMapping("/friends")
    public String addFriend(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }
}
