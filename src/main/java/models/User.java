package models;

import enums.Role;

public record User(int id, String firstName, String lastName, String address, String email,
                   String password, Role role, int isActive, String createdAt, String updatedAt) {}
