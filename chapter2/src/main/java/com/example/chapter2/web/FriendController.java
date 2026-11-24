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
public class FriendController {

    private final List<Friend> friends = new ArrayList<>();

    // Show friend list: http://localhost:8080/friendlist
    @GetMapping("/friendlist")
    public String friendList(Model model) {
        model.addAttribute("friends", friends);
        return "friendlist";
    }

    // Open "Add new friend" page
    @GetMapping("/add")
    public String addFriend(Model model) {
        model.addAttribute("friend", new Friend());
        return "addfriend";
    }

    // Save new friend and go back to the list
    @PostMapping("/save")
    public String save(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friendlist";
    }
}
