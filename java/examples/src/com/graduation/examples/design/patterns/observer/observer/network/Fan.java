package com.graduation.examples.design.patterns.observer.observer.network;


import com.graduation.examples.design.patterns.observer.observer.Observer;
import com.graduation.examples.design.patterns.observer.observer.Subject;

import java.util.HashSet;
import java.util.Set;


public class Fan implements Observer {
    private String name;
    private Set<Artist> followedSubjects;

    public Fan(String name){
        this.followedSubjects = new HashSet<>();
        this.name = name;
    }

    public Fan(Set<Artist> subjectsToFollow) {
        this.followedSubjects = subjectsToFollow;
    }

    public void addSubject(Artist subject){
        subject.subscribe(this);
        this.followedSubjects.add(subject);
    }

    public Set<Artist> getFollowedSubjects() {
        return new HashSet<>(followedSubjects);
    }

    @Override
    public void receiveNotification(Subject from) {
        System.out.println("[" + this.name + "] " + from.getLastNotification());
    }
}
