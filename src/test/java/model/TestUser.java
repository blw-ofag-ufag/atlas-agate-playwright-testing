package model;

public record TestUser(
        Personal personal,
        Contact contact
) {
    public record Personal(
            String salutation,
            String fullName,
            String birthYear) {}

    public record Contact(
            String email,
            String mobile,
            String address,
            String phone,
            String language) {}
}
